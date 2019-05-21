package lesson4;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.abs;

public class lesson4 {
    public static int SIZE = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {

        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(map)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(map)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static boolean checkWin(char[][] arr) {
        int sumGor;
        int sumVer;
        int sumD1 = 0;
        int sumD2 = 0;

        for (int i = 0; i < arr.length; i++) {  //проверяю горизонтали
            sumGor = 0;
            for (int j = 0; j < arr[i].length; j++) {
                switch (arr[i][j]) {
                    case 'X':
                        sumGor += 1;
                        break;
                    case 'O':
                        sumGor += -1;
                        break;
                    default:
                        break;
                }
            }

            if (abs(sumGor) == arr.length) {
                return true;
            }
        }

        for (int i = 0; i < arr.length; i++) {  //проверяю вертикали
            sumVer = 0;
            for (int j = 0; j < arr[i].length; j++) {
                switch (arr[j][i]) {
                    case 'X':
                        sumVer += 1;
                        break;
                    case 'O':
                        sumVer += -1;
                        break;
                    default:
                        break;
                }
            }

            if (abs(sumVer) == arr.length) {
                return true;
            }
        }

        for (int i = 0; i < arr.length; i++) {  //проверяю диагонали
            for (int j = 0; j < arr[i].length; j++) {
                switch (arr[j][i]) {
                    case 'X':
                        if (i == j) {
                            sumD1 += 1;
                        }
                        if (i + j == arr.length - 1) {
                            sumD2 += 1;
                        }
                        break;
                    case 'O':
                        if (i == j) {
                            sumD1 += -1;
                        }

                        if (i + j == arr.length - 1) {
                            sumD2 += -1;
                        }
                        break;
                    default:
                        break;
                }

                if ((abs(sumD1) == arr.length) || (abs(sumD2) == arr.length)) {
                    return true;
                }
            }
        }
        return false;
    }
}
