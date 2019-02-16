package lesson10homework.task2;


import java.util.HashMap;
import java.util.Map;

public class Garage {

    private static HashMap<Car, Integer> garage;

    public Garage() {
        Garage.garage = new HashMap<>();
    }

    public void parkIn(Car... car) {
        for (Car car1 : car) {
            if (garage.containsKey(car1)) {
                garage.put(car1, garage.get(car1) + 1);
            } else {
                garage.put(car1, 1);
            }
        }
    }

    public int brandInGarage(String brandName) {
        return garage.entrySet().stream().filter(entry -> entry.getKey().getBrand().equals(brandName))
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    public boolean parkOut(Car car) {
        if (garage.containsKey(car)) {
            garage.put(car, garage.get(car) - 1);
            if (garage.get(car) == 0) {
                garage.remove(car);
            }
            return true;
        } else {
            return false;
        }
    }

    public int getTruckQty() {
        int result = 0;
        for (Car car : garage.keySet()) {
            if (car instanceof Truck) {
                result += garage.get(car);
            }
        }
        return result;
    }

    public int getPassangerCarQty() {
        int result = 0;
        for (Car car : garage.keySet()) {
            if (car instanceof PassangerCar) {
                result += garage.get(car);
            }
        }
        return result;
    }

    public int getMinivanQty() {
        int result = 0;
        for (Car car : garage.keySet()) {
            if (car instanceof Minivan) {
                result += garage.get(car);
            }
        }
        return result;
    }

    public int getPickupQty() {
        int result = 0;
        for (Car car : garage.keySet()) {
            if (car instanceof Pickup) {
                result += garage.get(car);
            }
        }
        return result;
    }

    public int getBrandQty(String brand) {
        int result = 0;
        for (Car car : garage.keySet()) {
            if (car.getBrand().equals(brand)) {
                result += garage.get(car);
            }
        }
        return result;
    }

    public int getYearQty(int year) {
        int result = 0;
        for (Car car : garage.keySet()) {
            if (car.getYear() == year) {
                result += garage.get(car);
            }
        }
        return result;
    }

    public int getAllCarsInGarage() {
        int counter = 0;
        if (!garage.isEmpty()) {
            for (Integer value : garage.values()) {
                counter += value;
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Car car : garage.keySet()) {
            result.append("Машин : ").append(car.getBrand()).append(" ").append(car.getModel())
                    .append(" в гараже : ").append(garage.get(car)).append("\n");
        }
        return result.toString();
    }

    public boolean isCarInGarage(Car car) {
        return garage.containsKey(car);
    }

    public Map<Car, Integer> getGarage() {
        return garage;
    }
}
