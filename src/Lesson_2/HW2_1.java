package Lesson_2;

import java.util.Scanner;

public class HW2_1 {
    public static void main(String[] args) {
        int year, month, day;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите год : ");
        year = in.nextInt();
        System.out.println(isLeap(year) ? "Высокосный" : "Не высокосный");
        System.out.print("\nВведите месяц : ");
        month = in.nextInt();
        while (month <= 0 || month > 12) {
            System.out.println("\nНекорректное значение месяца. Повторите ввод : ");
            month = in.nextInt();
        }
        System.out.print("\nВведите день : ");
        day = in.nextInt();
        while (day <= 0 || day > dayInMonth(isLeap(year), month)) {
            System.out.print("\nНекорректное значение дня. Повторите ввод : ");
            day = in.nextInt();
        }
        System.out.println("Введенный день : " + day + "." + month + "." + year);
        System.out.println(nextDay(year, month, day));

    }

    public static String nextDay(int year, int month, int day) {
        if (day != dayInMonth(isLeap(year), month)) {
            day++;
        } else if (month != 12) {
            month++;
            day = 1;
        } else {
            year++;
            month = 1;
            day = 1;
        }
        return "Следующий день : " + day + "." + month + "." + year;
    }

    public static int dayInMonth(boolean ifLeap, int month) {
        switch (month) {
            case 1:
                return 31;
            case 2:
                return ifLeap ? 29 : 28;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return -1;
        }
    }

    public static boolean isLeap(int year) {
        if (year < 0) {
            System.out.println("Отрицательное значение года.");
            return false;
        } else {
            boolean result = false;
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                result = true;
            }
            return result;
        }
    }
}
