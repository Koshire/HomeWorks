package Lesson_2;

import java.util.Scanner;

public class HW2_2 {
    public static void main(String[] args) {
        int areaWigth, areaLenth, firstHouseWigth, firstHouseLenth, secondHouseWigth, secondHouseLenth;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размеры участка : ");
        System.out.print("Ширина : ");
        areaWigth = in.nextInt();
        System.out.print("Длина : ");
        areaLenth = in.nextInt();
        System.out.println("Введите размеры первого дома : ");
        System.out.print("Ширина : ");
        firstHouseWigth = in.nextInt();
        System.out.print("Длина : ");
        firstHouseLenth = in.nextInt();
        System.out.println("Введите размеры второго дома : ");
        System.out.print("Ширина : ");
        secondHouseWigth = in.nextInt();
        System.out.print("Длина : ");
        secondHouseLenth = in.nextInt();
        System.out.println(areaLoad(areaWigth, areaLenth, firstHouseWigth, firstHouseLenth, secondHouseWigth, secondHouseLenth));

    }

    public static boolean areaLoad(int areaWigth, int areaLenth, int firstWigth, int firstLenth, int secondWigth, int secondLenth) {
        boolean result = false;
        if (eqSquare(areaWigth, areaLenth, firstWigth, firstLenth) &&
                eqSquare(areaWigth - firstWigth, areaLenth - firstLenth, secondWigth, secondLenth) ||
                eqSquare(areaWigth - firstLenth, areaLenth - firstWigth, secondWigth, secondLenth)) {
            result = true;
        }
        return result;
    }

    public static boolean eqSquare(int firstW, int firstL, int secondW, int secondL) {
        int firstValL, firstValW, secondValL, secondValW;
        if (firstW <= firstL) {
            firstValL = firstW;
            firstValW = firstL;
        } else {
            firstValL = firstL;
            firstValW = firstW;
        }
        if (secondW <= secondL) {
            secondValL = secondW;
            secondValW = secondL;
        } else {
            secondValL = secondL;
            secondValW = secondW;
        }
        boolean result = false;
        if (firstValL <= secondValL && firstValW <= secondValW) {
            result = true;
        }
        return result;
    }

}
