package lesson10homework.task2;

public abstract class Car {

    private String brand;
    private String model;
    private int year;
    private String fuel;
    private String colour;
    private double engineValue;

    public Car(String brand, String model, int year, String fuel, String colour, double engineValue) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuel = fuel;
        this.colour = colour;
        this.engineValue = engineValue;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getFuel() {
        return fuel;
    }

    public String getColour() {
        return colour;
    }

    public double getEngineValue() {
        return engineValue;
    }
}
