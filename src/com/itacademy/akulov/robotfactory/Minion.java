package com.itacademy.akulov.robotfactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Minion extends Thread {

    private static final int DETAILS_PER_NIGHT = 4;

    private ScrapDump dump;
    private MadFactory myFactory;
    private Map<RobotDetails, Integer> basket = new HashMap<>();

    public Minion(ScrapDump dump, MadFactory myFactory) {
        this.dump = dump;
        this.myFactory = myFactory;
    }

    private void collectDetail() {
        int counterCubic = RandomUtils.randomQuantitu(DETAILS_PER_NIGHT);
        for (int i = 0; i <= counterCubic; i++) {
            List<RobotDetails> list = dump.getGarbage().entrySet().stream()
                    .filter(value -> value.getValue() != 0).map(Map.Entry::getKey)
                    .collect(Collectors.toList());
            int cubicValue = RandomUtils.dropCubic(list.size());
            if (list.size() != 0 && dump.exludeDetailMap(list.get(cubicValue))) {
                basket.merge(list.get(cubicValue), 1, (oldVal, newVal) -> oldVal + newVal);
            }
        }
    }

    private void dropDetailsToBase() {
        myFactory.fillWareHouse(basket);
        basket.clear();
    }

    @Override
    public void run() {
        synchronized (dump) {
            while (!Competition.isOver()) try {
                System.out.println("Собираю детали. Оповещение от миньона фабрики: " + myFactory.getMyName());
                collectDetail();
                System.out.println(basket);
                System.out.println("Оповещаю, что все собрал. Оповещение от миньона фабрики: " + myFactory.getMyName());
                System.out.println("Отдаю детали на фабрику. Оповещение от миньона фабрики: " + myFactory.getMyName());
                dropDetailsToBase();
                System.out.println(myFactory.getWarehouse());
                System.out.println(myFactory.getWarehouse().size());
                System.out.println("Ожидаю оповещение о новом дне. Оповещение от миньона фабрики: " + myFactory.getMyName());
                dump.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
