package lesson3_2level;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] arrayStr = new String[]{"кот", "собака", "азбука", "песня", "собака", "огурец", "огурец", "кот", "кот", "кот", "азбука", "азбука"};
        isUnique(arrayStr);
        isNumberWords(arrayStr);
    }

    static void isUnique(String[] arrayStr){
        Set<String> arrSet = new HashSet<>();
        for (String arr: arrayStr) {
            arrSet.add(arr);
        }
        System.out.println(arrSet);
    }

    static void isNumberWords(String[] arrayStr) {
        List<String> listArray = new ArrayList<>();
        int n = 0;
        for (String arr : arrayStr) {
            listArray.add(arr);
        }
        for (int i = 0; i < listArray.size(); i = 0) {
            Iterator<String> iterator = listArray.iterator();
            String str1 = listArray.get(i);
            while (iterator.hasNext()) {
                String str2 = iterator.next();
                if (str1.equals(str2)) {
                    n++;
                    iterator.remove();
                }
            }
            System.out.println(str1 + " встречается " + n + " раз(а)");
            n = 0;
        }
    }
}
