package com.itacademy.akulov.robotfactory;

public class RobotDemo {

    public static void main(String[] args) throws InterruptedException {
        ScrapDump collector = new ScrapDump();
        Fabric fabric = new Fabric(collector);
        MadFactory firstFactory = new MadFactory("Ioda", collector);
        MadFactory secondFactory = new MadFactory("Imperator", collector);

        fabric.start();
        firstFactory.start();
        secondFactory.start();

        fabric.join();

        System.out.println(firstFactory.getReadyRobotsCounter());
        System.out.println(secondFactory.getReadyRobotsCounter());
        if (firstFactory.getReadyRobotsCounter() == secondFactory.getReadyRobotsCounter()) {
            System.out.println("No One Win");
        } else {
            System.out.println((firstFactory.getReadyRobotsCounter() > secondFactory.getReadyRobotsCounter() &&
                    firstFactory.getReadyRobotsCounter() != secondFactory.getReadyRobotsCounter()) ?
                    "Win Fabric - " + firstFactory.getMyName() : "Win Fabric- " + secondFactory.getMyName());
        }

        firstFactory.join();
        secondFactory.join();
    }
}
