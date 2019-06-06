package lesson5_2;

public class ArrayMath {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    static void arrayMathWithouThread(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Время с 1 потоком: " + (System.currentTimeMillis() - a));
    }

    synchronized void arraySet(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    static class MyThread implements Runnable {
        float[] arr;

        public MyThread(float[] arr) {
            this.arr = arr;
        }

        @Override
        public void run() {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 1;
            }

            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }

    public static void main(String[] args) {
        float[] arr = new float[SIZE];
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];

        arrayMathWithouThread(arr);

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        new Thread(new MyThread(arr1)).start();
        new Thread(new MyThread(arr2)).start();

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        System.out.println("Время с 2мя потоками: " + (System.currentTimeMillis() - a));
        
        ArrayMath arrayMath = new ArrayMath();

        long b = System.currentTimeMillis();

        new Thread(() -> arrayMath.arraySet(arr1)).start();
        new Thread(() -> arrayMath.arraySet(arr2)).start();

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        System.out.println("Время с синхронизацией: " + (System.currentTimeMillis() - b));
    }
}







