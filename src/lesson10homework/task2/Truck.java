package lesson10homework.task2;

import java.util.Objects;

public class Truck extends Car {

    private int bodyVolume;
    private boolean isTrailer;
    private int fullMass;
    private double height;

    public Truck(String brand, String model, int year, String fuel, String colour,
                 double engineValue, int bodyVolume, boolean isTrailer, int fullMass, double height) {
        super(brand, model, year, fuel, colour, engineValue);
        this.bodyVolume = bodyVolume;
        this.isTrailer = isTrailer;
        this.fullMass = fullMass;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Truck)) return false;
        Truck truck = (Truck) o;
        return getBodyVolume() == truck.getBodyVolume() &&
                getFullMass() == truck.getFullMass() &&
                isTrailer() == truck.isTrailer() &&
                getBrand().equals(truck.getBrand()) &&
                getModel().equals(truck.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isTrailer(), getFullMass(), getBodyVolume(), getBrand(),
                getModel());
    }

    @Override
    public String toString() {
        return "Truck " +
                " brand=" + getBrand() +
                ", model=" + getModel() +
                ", year=" + getYear() +
                ", fuel=" + getFuel() +
                ", colour=" + getColour() +
                ", engineValue=" + getEngineValue() +
                ", bodyVolume=" + bodyVolume +
                ", isTrailer=" + isTrailer +
                ", fullMass=" + fullMass +
                ", height=" + height;
    }

    public int getBodyVolume() {
        return bodyVolume;
    }

    public boolean isTrailer() {
        return isTrailer;
    }

    public int getFullMass() {
        return fullMass;
    }

    public double getHeight() {
        return height;
    }
}
