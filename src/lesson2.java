public class lesson2 {
    public static void main(String[] args) {

        int[][] table = new int[6][6];
        arrDiagonal(table);

        System.out.println();

        invertArray();

        System.out.println();

        fillArr();

        System.out.println();

        changeArr();

        System.out.println();

        arrMinMax();
    }

    public static void changeArr() {
        int[] changeArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < changeArr.length; i++) {
            if (changeArr[i] < 6) {
                changeArr[i] = changeArr[i] * 2;
            }

            System.out.print(changeArr[i] + " ");
        }
    }

    public static void fillArr() {
        int[] fillArr = new int[8];
        int counter = 0;
        for (int i = 0; i < fillArr.length; i++) {
            fillArr[i] = counter;
            System.out.print(fillArr[i] + " ");
            counter += 3;
        }
    }

    public static void invertArray() {
        int[] invertArr = {1, 1, 0, 0};
        for (int i = 0; i < invertArr.length; i++) {
            if (invertArr[i] == 0){
                invertArr[i] = 1;
            } else {
                invertArr[i] = 0;
            }
            System.out.print(invertArr[i] + " ");
        }
    }

    public static void arrDiagonal(int[][] arr) {
        for (int i = 0; i < arr.length; i ++) {
            for (int j = 0; j < arr[i].length; j++) {
              if ((i == j) || (i + j == arr.length - 1)) {
                  arr[i][j] = 1;
              } else {
                  arr[i][j] = 0;
              }
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void arrMinMax() {

        int[] arrMinMax = {9, 4, 10, 2, 77};
        if (arrMinMax.length != 0) {
            int min = arrMinMax[0];
            int max = arrMinMax[0];
            for (int i = 0; i < arrMinMax.length; i++) {
                if (arrMinMax[i] < min) {
                    min = arrMinMax[i];
                }

                if (arrMinMax[i] > max) {
                    max = arrMinMax[i];
                }
            }

            System.out.println("Max " + max + " и Min " + min);
        } else {
            System.out.println("Ошибка");
        }
    }
}
