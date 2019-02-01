package Lesson_3;

import java.util.Scanner;

public class HW3_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter day quantity :");
        int qtDays = in.nextInt();
        int value = 0;
        int valResult = 0;
        int maxVal = 0;
        for (int i = 1; i <= qtDays; i++) {
            System.out.print("Введите кол-во осадков " + i + " : ");
            value = in.nextInt();
            valResult += value;
            if (value > maxVal) {
                maxVal = value;
            }
        }
        int averVal = valResult / qtDays;
        System.out.println("За дней :" + qtDays + ", выпало в среднем  : " + averVal + " осадков.");
        System.out.println("В сумме :" + valResult + ", максимальное значение в день : " + maxVal + " осадков.");
    }

}

