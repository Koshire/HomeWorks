package Lesson_5;

import java.util.Scanner;

public class HW5_1 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку : ");
        String valueString = in.nextLine();
        String result = palindrome(valueString) ? "Строка является палиндромом"
                                                : "Строка не является палиндромом";
        System.out.println(result);
    }

    public static boolean palindrome(String valueString) {
        String tempString = valueString.replaceAll("[.,! ]", "");
        StringBuilder resultString = new StringBuilder();

        for (int i = tempString.length() - 1; i >= 0; i--) {
            resultString.append(tempString.charAt(i));
        }
        return resultString.toString().equalsIgnoreCase(tempString);
    }
}
