package com.itacademy.akulov.robotfactory;

import java.util.Random;

public class RandomUtils {

    public static RobotDetails randomDetail() {
        Random random = new Random();
        return RobotDetails.values()[random.nextInt(RobotDetails.values().length)];
    }

    public static int dropCubic(int quantity) {
        Random random = new Random();
        return quantity != 0 ? random.nextInt(quantity) : 0;
    }

    public static int randomQuantitu(int quantity) {
        Random random = new Random();
        return quantity != 0 ? random.nextInt(quantity) + 1 : 0;
    }
}
