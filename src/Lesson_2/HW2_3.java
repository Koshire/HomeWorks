package Lesson_2;

import java.sql.SQLOutput;
import java.util.Scanner;

public class HW2_3 {
    public static void main(String[] args) {
        double a, b, c, x1, x2;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите числа : ");
        System.out.print("Первое : ");
        a = in.nextDouble();
        System.out.print("Второе : ");
        b = in.nextDouble();
        System.out.print("Третье : ");
        c = in.nextDouble();
        double D = discriminant(a, b, c);

        if (isZero(D)) {
            x1 = x2 = (-b + Math.sqrt(D)) / 2 * a;
            System.out.println(" x1 = x2 = " + x1);
        } else if (isPositive(D)) {
            x1 = (-b + Math.sqrt(D)) / 2 * a;
            x2 = (-b - Math.sqrt(D)) / 2 * a;
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        } else {
            System.out.println("Дискриминант является отрицательным числом, корни - комплексные числа.");
        }

    }

    public static boolean isPositive(double mayBePositive) {
        return mayBePositive >= 0;
    }

    public static boolean isZero(double mayBeZero) {
        return mayBeZero == 0;
    }

    public static double discriminant(double a, double b, double c) {
        double D = b * b - 4 * a * c;
        return D;
    }
}
