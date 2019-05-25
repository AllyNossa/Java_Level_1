package lesson2_2level;

public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        int a = 5;
        int b = 5;
        String[][] array = new String[a][b];
        getArrayException(array, a, b);

        String[][] arr = {{"111", "53gg6"}, {"4555", "33333"}};
        System.out.println(sumAray(arr));
    }

    static void getArrayException(String[][] str, int a, int b) throws MyArraySizeException {
        str = new String[a][b];
        if ((a != 4) && (b != 4))
            throw new MyArraySizeException("В метод передали массив не того размера: [" + a + "][" + b + "]");
    }

    static int sumAray(String[][] str) throws MyArrayDataException {
        int sum = 0;
        int number;
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length; j++) {
                String a = str[i][j];
                if (!onlyNumber(a))
                    throw new MyArrayDataException("В ячейке массива с координатами (" + i + ", " + j + ") лежат символы");
                number = Integer.parseInt(a);
                sum += number;
            }
        }
        return sum;
    }

    static boolean onlyNumber(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
