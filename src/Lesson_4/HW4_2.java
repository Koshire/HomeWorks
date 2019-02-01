package Lesson_4;

import java.util.Arrays;

public class HW4_2 {

    public static void main(String args[]) {
        int[] arrValue = {1, 3, 3, 4, 5, 5, 7, 0, 9, 0};
        delDupInt(arrValue);
        System.out.println(Arrays.toString(arrValue));
    }

    public static void delDupInt(int... valArray) {
        for (int i = 0; i < valArray.length; i++) {
            for (int j = 0; j < valArray.length; j++) {
                if (j != i && valArray[i] == valArray[j] && valArray[i] != 0) {
                    valArray[j] = 0;
                }
            }
        }
    }
}
