/*
Написать программу, вычисляющую и отображающую все числа
Фибоначчи меньше введённого пользователем целого числа.
    Решить двумя способами: с помощью цикла и с помощью
рекурсии.
*/

package Lesson_3;

import java.util.Scanner;

public class HW3_2_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number :");
        int value = in.nextInt();
        fibOfNum(value);
    }

    public static void fibOfNum(int num) {
        int result1 = 0;
        int result2;
        int fiboNum = 0;
        if (num >= 0) {
            System.out.println(fiboNum);
            result2 = ++fiboNum;
            while (fiboNum <= num) {
                System.out.println(fiboNum);
                fiboNum = result1 + result2;
                result1 = result2;
                result2 = fiboNum;
            }
        }
    }
}
