package lesson10homework.task2;

import java.util.Objects;

public class PassangerCar extends Car {


    private String bodyType;
    private String driveUnit;

    public PassangerCar(String brand, String model, int year, String fuel,
                        String colour, double engineValue, String bodyType, String driveUnit) {
        super(brand, model, year, fuel, colour, engineValue);
        this.bodyType = bodyType;
        this.driveUnit = driveUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassangerCar)) return false;
        PassangerCar that = (PassangerCar) o;
        return getDriveUnit().equals(that.getDriveUnit()) && getBodyType().equals(that.getBodyType()) &&
                getBrand().equals(that.getBrand()) && getModel().equals(that.getModel());
    }

    @Override
    public int hashCode() {
        int result = getBodyType().hashCode();
        result = 31 * result + getDriveUnit().hashCode();
        return result + Objects.hash(getBrand(), getModel());
    }

    @Override
    public String toString() {
        return "PassangerCar" +
                " brand=" + getBrand() +
                ", model=" + getModel() +
                ", year=" + getYear() +
                ", fuel=" + getFuel() +
                ", colour=" + getColour() +
                ", engineValue=" + getEngineValue() +
                ", bodyType='" + bodyType +
                ", driveUnit='" + driveUnit;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getDriveUnit() {
        return driveUnit;
    }
}
