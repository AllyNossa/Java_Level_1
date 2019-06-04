package lesson5_2;

public class ArrayWithoutThread {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    static void arraySet(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println(System.currentTimeMillis()- a);
    }

    static void arraySetThread(float[] arr, float[] arr1, float[] arr2, int size, Thread thread, Thread thread2) {
        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, size);
        System.arraycopy(arr, size, arr2, 0, size);

        thread.start();

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 1;
        }

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = 1;
        }

        thread2.start();

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
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

        arraySet(arr);

        MyThreads myThread = new MyThreads();
        MyThreads myThread2 = new MyThreads();

        Thread thread = new Thread(myThread);
        Thread thread2 = new Thread(myThread2);

        arraySetThread(arr, arr1, arr2, HALF, thread, thread2);
    }
}

class MyThreads extends Thread {

}





