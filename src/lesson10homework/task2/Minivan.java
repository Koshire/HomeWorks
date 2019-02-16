package lesson10homework.task2;

import java.util.Objects;

public class Minivan extends Car {

    private int numberOfSeats;
    private boolean railings;
    private int trunkVolume;

    public Minivan(String brand, String model, int year, String fuel, String colour,
                   double engineValue, int numberOfSeats, boolean railings, int trunkVolume) {
        super(brand, model, year, fuel, colour, engineValue);
        this.numberOfSeats = numberOfSeats;
        this.railings = railings;
        this.trunkVolume = trunkVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Minivan)) return false;
        Minivan minivan = (Minivan) o;
        if (getNumberOfSeats() != minivan.getNumberOfSeats()) return false;
        return getTrunkVolume() == minivan.getTrunkVolume() && getBrand().equals(((Minivan) o).getBrand()) &&
                getModel().equals(((Minivan) o).getModel());
    }

    @Override
    public int hashCode() {
        int result = getNumberOfSeats();
        result = 31 * result + getTrunkVolume();
        return result + Objects.hash(getBrand(), getModel());
    }

    @Override
    public String toString() {
        return "Minivan" +
                " brand=" + getBrand() +
                ", model=" + getModel() +
                ", year=" + getYear() +
                ", fuel=" + getFuel() +
                ", colour=" + getColour() +
                ", engineValue=" + getEngineValue() +
                ", numberOfSeats=" + numberOfSeats +
                ", railings=" + railings +
                ", trunkVolume=" + trunkVolume;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public boolean isRailings() {
        return railings;
    }

    public int getTrunkVolume() {
        return trunkVolume;
    }
}
