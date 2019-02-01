package Lesson_3;

import java.util.Scanner;

public class HW3_2_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number : ");
        int value = in.nextInt();
        int counter = 0;
        int result;
        while (fibOfNums(counter) < value) {
            result = fibOfNums(counter);
            System.out.println(result);
            counter++;
        }
    }

    public static int fibOfNums(int num) {
        if (num == 0)
            return 0;
        else if (num == 1)
            return 1;
        else
            return fibOfNums(num - 1) + fibOfNums(num - 2);
    }

}