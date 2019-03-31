public class lesson_1 {
    public static void main(String[] args) {
        short a1 = 10000;
        byte a2 = -100;
        int a3 = 1000000;
        long a4 = -10000000;
        float a5 = 23.45f;
        double a6 = -115.145;
        char a7 = '&';
        boolean a8 = false;

        System.out.println(mathExpression(1, 2, 4, 2));
        System.out.println(sum10to20(10, 30));
        positiveOrNegative(30);
        System.out.println(isNegative(-50));
        helloName("Василий");
        isLeapYear(2100);

    }

    public static int mathExpression(int a, int b, int c, int d) {
        return (a * (b + (c / d)));
    }

    public static boolean sum10to20(int a, int b) {
        int sum = a + b;
        if (sum > 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void positiveOrNegative(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean isNegative(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void helloName(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void isLeapYear(int year) {
        if (year % 4 == 0) {
            if ((year % 400 == 0) || (year % 100 != 0)) {
                System.out.println("Год високосный");
            } else {
                System.out.println("Год не високосный");
            }
        } else {
            System.out.println("Год не високосный");
        }
    }
}

