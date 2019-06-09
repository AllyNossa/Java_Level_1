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

    static void waitThreadFinish(Thread thread){
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyThread implements Runnable {
        float[] arr;
        float delta;

        public MyThread(float[] arr, float delta) {
            this.arr = arr;
            this.delta = delta;
        }

        @Override
        public void run() {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 1;
            }

            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + delta)/ 5) * Math.cos(0.2f + (i + delta)/ 5) * Math.cos(0.4f + (i + delta) / 2));
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

        Thread thread1 = new Thread(new MyThread(arr1, 0));
        Thread thread2 = new Thread(new MyThread(arr2, HALF));

        thread1.start();
        thread2.start();

        waitThreadFinish(thread1);
        waitThreadFinish(thread2);

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        System.out.println("Время с 2мя потоками: " + (System.currentTimeMillis() - a));
    }
}





