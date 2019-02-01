package Lesson_4;

import java.util.Arrays;

public class HW4_3 {

    public static void main(String args[]) {
        int[] arrFirst = {1, 2, 4, 9, 0, 1, 3};
        int[] arrSecond = {5, 3};
        int[] arrSum = new int[arrFirst.length + arrSecond.length];
        arrSumma(arrFirst, arrSecond, arrSum);
        System.out.println(Arrays.toString(arrSum));
    }

    public static void arrSumma(int[] valFirst, int[] valSecond, int[] valSum) {
        int i = 0, j = 0, k = 0;
        while (i < valSum.length) {
            if (j < valFirst.length) {
                valSum[i] = valFirst[j];
                j++;
                i++;
            }
            if (k < valSecond.length) {
                valSum[i] = valSecond[k];
                k++;
                i++;
            }
        }
    }
}
