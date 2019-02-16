package lesson10homework.task1;

import java.util.HashMap;
import java.util.Map;

public class UniqueWords {

    public static void main(String[] args) {
        String string = "Opps!!!   Earth Hello!   planet   hello, hello world world. planet world Earth, Earth Hello hello     ";
        printUniqueMap(getUniqueMap(string));
    }

    private static void printUniqueMap(Map map){
        if (!map.isEmpty()) {
            for (Object keyValue : map.keySet()) {
                System.out.println("Слово: " + keyValue + " встречается : " + map.get(keyValue) + " раз(а).");
            }
        } else {
            System.out.println("Нечего печатать!");
        }
    }

    private static Map<String, Integer> getUniqueMap(String string) {
        String resultString = string.replaceAll("[,.!?]", "").replaceAll("\\s{2,}"," ").trim();
        String[] stringArray = resultString.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String keyValue : stringArray) {
            if (!map.containsKey(keyValue)){
                map.put(keyValue, 1);
            } else {
                map.put(keyValue, map.get(keyValue)+1);
            }
        }
        return map;
    }
}
