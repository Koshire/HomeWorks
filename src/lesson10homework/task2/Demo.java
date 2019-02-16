package lesson10homework.task2;

public class Demo {

    public static void main(String[] args) {

        Truck firstTruck = new Truck("VW", "LT", 1989, "Diesel", "Blue",
                2.4, 5, false, 3500, 2.3);
        Truck secondTruck = new Truck("VW", "LT", 1992, "Diesel", "Blue",
                2.4, 5, false, 3500, 2.3);
        Truck thirdTruck = new Truck("Fiat", "Truck", 2011, "Disel", "White",
                2.3, 8, false, 3500, 2.5);
        Truck fourTruck = new Truck("Volvo", "VV", 2014, "Disel", "Red",
                5.7, 20, false, 4200, 2.6);
        Truck fiveTruck = new Truck("Ford", "Ecua", 2008, "Gas", "Black",
                6.2, 20, false, 4200, 2.4);
        PassangerCar firstPC = new PassangerCar("Fiat", "Multipla", 2002, "Gas",
                "Gold", 1.9, "Hatch", "Front");
        PassangerCar secondPC = new PassangerCar("Ford", "Fiesta", 2016, "Gas",
                "Red", 1.6, "Hatch", "Front");
        PassangerCar thirdPC = new PassangerCar("Geep", "Cheroke", 2013, "Diesel",
                "Black", 3.5, "Geep", "Full");
        PassangerCar fourPC = new PassangerCar("Geep", "Cheroke", 2009, "Gas",
                "White", 2.0, "Geep", "Full");
        Minivan firstVan = new Minivan("Renault", "Epace", 2006, "Diesel",
                "green", 2.0, 6, true, 400);
        Minivan SecondVan = new Minivan("Fiat", "Ulysse", 2003, "Diesel",
                "blue", 2.2, 7, true, 500);
        Minivan thirdVan = new Minivan("Renault", "Espace", 2004, "Diesel",
                "black", 2.2, 6, true, 400);
        Pickup firstUp = new Pickup("Ford", "F150", 2011, "gas",
                "white", 5.7, false, true, false);
        Pickup secondUp = new Pickup("Ford", "F150", 2011, "gas",
                "white", 5.7, false, true, false);
        Pickup thirdUp = new Pickup("Ford", "F150", 2011, "gas",
                "white", 5.7, false, true, false);

        Garage garage = new Garage();

        System.out.println(firstTruck.equals(secondTruck));
        System.out.println(firstTruck.hashCode());
        System.out.println(secondTruck.hashCode());
        System.out.println(thirdPC.equals(fourPC));
        System.out.println(thirdPC.hashCode());
        System.out.println(fourPC.hashCode());
        System.out.println("Машин выпуска 2011 года в гараже : " + garage.getYearQty(2011));
        garage.parkIn(firstPC, firstTruck, secondPC, secondTruck, thirdPC, thirdTruck, fourPC,
                fourTruck, fiveTruck, firstVan, SecondVan, thirdVan, firstUp, secondUp, thirdUp);
        garage.parkOut(firstPC);
        System.out.println(garage.toString());
        System.out.println("Всего в гараже автомобилей : " + garage.getAllCarsInGarage());
        System.out.printf("Автомобилей марки Ford в гараже : %d \n", garage.getBrandQty("Ford"));
        System.out.printf("Автомобилей марки Geep в гараже : %d \n", garage.getBrandQty("Geep"));
        System.out.println("Грузовых автомобилей в гараже : " + garage.getTruckQty());
        System.out.println("Легковых автомобилей в гараже : " + garage.getPassangerCarQty());
        System.out.println("Минивенов автомобилей в гараже : " + garage.getMinivanQty());
        System.out.println("Пикапов автомобилей в гараже : " + garage.getPickupQty());
        System.out.println(garage.parkOut(firstUp) ? "Машина " + firstUp.toString() + " выехала." : "Запрошенной машины нет в гараже.");
        System.out.println("Машин бренда Ford в гараже : " + garage.brandInGarage("Ford"));
        System.out.println("Машин выпуска 2011 года в гараже : " + garage.getYearQty(2011));
    }
}