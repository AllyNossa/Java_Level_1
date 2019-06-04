package lesson5_2;

public class ArrayMath {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    static void arraySetWithouThread(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println(System.currentTimeMillis()- a);
    }

    static void arraySetThread(float[] arr, float[] arr1, float[] arr2, int size) {
        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, size);
        System.arraycopy(arr, size, arr2, 0, size);

        Thread thread1 = new Thread();
        Thread thread2 = new Thread();

        thread1.start();
        thread2.start();

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 1;
        }

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = 1;
        }

        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.arraycopy(arr1, 0, arr, 0, size);
        System.arraycopy(arr2, 0, arr, size, size);

        System.out.println(System.currentTimeMillis()- a);
    }

    public static void main(String[] args) {
        float[] arr = new float[SIZE];
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];

        arraySetWithouThread(arr);

        arraySetThread(arr, arr1, arr2, HALF);
    }
}







