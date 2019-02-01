/*
1. Написать программу, вычисляющую сумму цифр введённого
пользователем целого числа.
*/

package Lesson_3;

import java.util.Scanner;

public class HW3_1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите число : ");
        int value = in.nextInt();

        if (value / 10 == 0) {
            System.out.println("Cумму цифр введённого пользователем целого числа равна :" + value);
        } else {
            System.out.println("Cумму цифр введённого пользователем целого числа равна :" + sumOfNums(value));
        }

    }

    private static int sumOfNums(int value) {
        int result = 0;
        while (value != 0) {
            result += value % 10;
            value /= 10;
        }
        return result;
    }

}
