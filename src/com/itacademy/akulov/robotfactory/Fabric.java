package com.itacademy.akulov.robotfactory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Fabric extends Thread {

    private static final int DAYS_QUANTITY = 100;
    private static final long DAYS_LENGHT = 100L;
    private static final int DETAIL_FIRST_NIGHT = 20;
    private static final int DETAILS_PER_NIGHT = 4;

    private ScrapDump dump;

    @Override
    public void run() {

        synchronized (dump) {
            Competition.setOver(false);
            System.out.println("Выкидываю первые детали. ГОЛОВНОЕ ПРОИЗВОДСТВО.");
            dump.fillDetailMap(DETAIL_FIRST_NIGHT);
            System.out.println("Оповещаю всех. ГОЛОВНОЕ ПРОИЗВОДСТВО.");
            dump.notifyAll();
            try {
                System.out.println("Жду новый день. ГОЛОВНОЕ ПРОИЗВОДСТВО.");
                dump.wait(DAYS_LENGHT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < DAYS_QUANTITY; i++) {
                System.out.println("Выкидываю новые детали. ГОЛОВНОЕ ПРОИЗВОДСТВО.");
                dump.fillDetailMap(RandomUtils.randomQuantitu(DETAILS_PER_NIGHT));
                System.out.println("Оповещаю всех. ГОЛОВНОЕ ПРОИЗВОДСТВО.");
                dump.notifyAll();
                try {
                    System.out.println("Жду новый день. ГОЛОВНОЕ ПРОИЗВОДСТВО.");
                    dump.wait(DAYS_LENGHT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Competition.setOver(true);
            dump.notifyAll();
        }
    }
}
