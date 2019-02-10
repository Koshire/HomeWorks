package lesson9homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class task1 {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>(Arrays.asList("this", "is", "lots", "of",
                "fun", "for", "every", "Java", "programmer"));

        markLength4(stringList);
        System.out.println(stringList.toString());
    }

    public static void markLength4(List stringList) {
        List<String> counters = new ArrayList<>();
        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().length() == 4) {
                counters.add(iterator.next());
            }
        }

        for (String tempString : counters) {
            if (stringList.indexOf(tempString) - 1 >= 0) {
                stringList.add(stringList.indexOf(tempString) - 1, "****");
            }
        }
    }
}
