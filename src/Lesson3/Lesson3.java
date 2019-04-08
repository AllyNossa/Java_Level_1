package Lesson3;

        import java.util.Random;
        import java.util.Scanner;

public class Lesson3 {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = 10;
        guessNumber(n);
        while (true) {
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            int repeatGame = sc.nextInt();
            if (repeatGame == 1) {
                guessNumber(n);
            } else if (repeatGame == 0) {
                System.out.println("Игра окончена");
                break;
            }
        }
    }

    public static void guessNumber(int number) {
        Random randomNumber = new Random();
        int x = randomNumber.nextInt(number);
        int counter = 3;

        for (int i = 0; i < 3; i++) {
            System.out.println("Количество попыток " + counter);
            System.out.println("Угадайте число до " + number);
            int m = sc.nextInt();
            if (m < x) {
                System.out.println("Загаданное число больше");
            } else if (m > x) {
                System.out.println("Загаданное число меньше");
            } else if (m == x) {
                System.out.println("Вы угадали!");
                break;
            }
            counter -= 1;
            if (counter == 0 ) {
                System.out.println("Вы проиграли!");
            }
        }
    }
}
