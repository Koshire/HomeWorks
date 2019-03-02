package com.itacademy.akulov.robotfactory;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class MadFactory extends Thread {

    private int readyRobotsCounter = 0;
    private String myName;
    private ScrapDump dump;
    private Map<RobotDetails, Integer> warehouse = new HashMap<>();

    public MadFactory(String name, ScrapDump dump) {
        this.myName = name;
        this.dump = dump;
    }

    public void fillWareHouse(Map<RobotDetails, Integer> basket) {
        basket.forEach((key, value) -> warehouse.merge(key, value, (oldVal, newVal) ->
                oldVal + newVal));
    }

    private boolean checkDetailQuantity() {
        return warehouse.size() == 9 && warehouse.values().stream()
                .min(Integer::compare).orElse(0) > 0;
    }

    private int produceRobots() {
        int robotsQuantity = 0;
        while (checkDetailQuantity()) {
            warehouse.entrySet().forEach(value -> value.setValue(value.getValue() - 1));
            robotsQuantity++;
        }
        readyRobotsCounter += robotsQuantity;
        return robotsQuantity;
    }

    @Override
    public void run() {
        synchronized (dump) {
            Minion myMinion = new Minion(dump, this);
            System.out.println("Создаю и запускаю миньона. Оповещение фабрики : " + myName);
            myMinion.start();
            while (!Competition.isOver()) {
                System.out.println("Проверяю и пытаюсь создать роботов. Создано :" + produceRobots()
                        + " .Оповещение фабрики : " + myName);
                try {
                    System.out.println("Жду оповещения о новом дне. Оповещение фабрики : " + myName);
                    dump.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                myMinion.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
