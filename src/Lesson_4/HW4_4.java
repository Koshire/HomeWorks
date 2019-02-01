package Lesson_4;

import java.util.Arrays;

public class HW4_4 {

    public static void main(String args[]) {
        int[][] arrValue = {{0, 1, 2, 3}, {0, 1, 2, 3, 1, 2, 3}, {0, 5, 6, 7}};
        System.out.println(Arrays.toString(linearize(arrValue)));
    }

    public static int[] linearize(int[][] valArray) {
        int k = 0;
        int mLen = 0;
        while (k < valArray.length) {
            mLen += valArray[k].length;
            k++;
        }

        int[] massSum = new int[mLen];
        int counter = 0;
        for (int i = 0; i < valArray.length; i++) {
            for (int j = 0; j < valArray[i].length; j++) {
                massSum[counter] = valArray[i][j];
                counter++;
            }
        }
        return massSum;
    }
}
