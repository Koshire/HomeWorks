package Lesson_5;

public class HW5_2 {

    public static void main(String args[]) {
        String rimNum = "MmmCMXCIX";
        System.out.println(arabicNumber(rimNum));
    }

    public static int arabicNumber(String valueString) {
        int resultNum = 0;
        resultNum += inArabicNum(valueString.toUpperCase().charAt(valueString.length() - 1));
        for (int i = valueString.length() - 2; i >= 0; i--) {
            if (inArabicNum(valueString.toUpperCase().charAt(i)) <
                            inArabicNum(valueString.toUpperCase().charAt(i + 1))) {
                resultNum -= inArabicNum(valueString.toUpperCase().charAt(i));
            } else {
                resultNum += inArabicNum(valueString.toUpperCase().charAt(i));
            }
        }
        return resultNum;
    }

    public static int inArabicNum(char numInRim) {
        int result;
        switch (numInRim) {
            case 'M':
                result = 1000;
                break;
            case 'D':
                result = 500;
                break;
            case 'C':
                result = 100;
                break;
            case 'L':
                result = 50;
                break;
            case 'X':
                result = 10;
                break;
            case 'V':
                result = 5;
                break;
            case 'I':
                result = 1;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }
}
