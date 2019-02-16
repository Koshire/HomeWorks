package lesson10homework.task2;

import java.util.Objects;

public class Pickup extends Car {

    private boolean isBigFoot;
    private boolean isFullSize;
    private boolean isParket;

    public Pickup(String brand, String model, int year, String fuel, String colour,
                  double engineValue, boolean isBigFoot, boolean isFullSize, boolean isParket) {
        super(brand, model, year, fuel, colour, engineValue);
        this.isBigFoot = isBigFoot;
        this.isFullSize = isFullSize;
        this.isParket = isParket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pickup)) return false;
        Pickup pickup = (Pickup) o;
        return isParket() == pickup.isParket() && isBigFoot() == pickup.isBigFoot() &&
                isFullSize() == pickup.isFullSize() && getBrand().equals(pickup.getBrand())
                && getModel().equals(pickup.getModel());
    }

    @Override
    public int hashCode() {
        int result = (isBigFoot() ? 1 : 0);
        result = 31 * result + (isFullSize() ? 1 : 0);
        result = 31 * result + (isParket() ? 1 : 0);
        return result + Objects.hash(getBrand(), getModel());
    }

    @Override
    public String toString() {
        return "Pickup" +
                " brand=" + getBrand() +
                ", model=" + getModel() +
                ", year=" + getYear() +
                ", fuel=" + getFuel() +
                ", colour=" + getColour() +
                ", engineValue=" + getEngineValue() +
                ", isBigFoot=" + isBigFoot +
                ", isFullSize=" + isFullSize +
                ", isParket=" + isParket;
    }

    public boolean isBigFoot() {
        return isBigFoot;
    }

    public boolean isFullSize() {
        return isFullSize;
    }

    public boolean isParket() {
        return isParket;
    }
}
