package Lesson3;

import java.util.Random;
import java.util.Scanner;

public class lesson3_2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        getWord(words);

    }

    public static void getWord(String[] words) {
        char[] answer = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
        Random random = new Random();
        int pos = random.nextInt(words.length);
        String guessWord = words[pos].toString();
        //System.out.println(guessWord);
        while (true) {
            System.out.println("Введите слово:");
            String wordUser = sc.next();
            int minLength;
            if (guessWord.equals(wordUser)) {
                System.out.println("Вы угадали");
                break;
            } else {
                if (guessWord.length() < wordUser.length()) {
                    minLength = guessWord.length();
                } else {
                    minLength = wordUser.length();
                }
                for (int i = 0; i < minLength; i++) {
                    char x = guessWord.charAt(i);
                    char y = wordUser.charAt(i);
                    if (x == y) {
                        answer[i] = x;
                    }
                    System.out.print(answer[i]);
                }
            }
            for (int j = 0; j < answer.length - minLength; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
