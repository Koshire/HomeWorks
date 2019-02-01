package Lesson_4;

import java.util.Arrays;

public class HW4_1 {

    public static void main(String args[]) {
        int[] arrValue = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        shiftArray(arrValue);
        shiftArray(arrValue);
        shiftArray(arrValue);
        System.out.println(Arrays.toString(arrValue));
    }


    public static void shiftArray(int[] valArray) {
        int temp = valArray[valArray.length - 1];
        for (int i = valArray.length - 1; i >= 0; i--) {
            if (i == 0) {
                valArray[i + 1] = valArray[i];
                valArray[i] = temp;
            } else {
                valArray[i] = valArray[i - 1];
            }
        }
    }
}
