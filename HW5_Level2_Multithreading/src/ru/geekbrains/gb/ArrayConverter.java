package ru.geekbrains.gb;

public class ArrayConverter {

    private static final int size = 10000000;
    private static final int half = size / 2;
    private float[] arr = new float[size];

    public void convertWithoutThreads() {
        //Arrays.fill(arr, 1);
        for (int i = 0; i < arr.length; i++)
            arr[i] = 1;

        long a = System.currentTimeMillis();
        fillNewly(arr);

        System.out.println("Converted without threads:");
        System.out.println(System.currentTimeMillis() - a);
    }

    public void convertWithThreads() {
        //Arrays.fill(arr, 1);
        for (int i = 0, len = arr.length; i < len; i++)
            arr[i] = 1;
        float[] arr1 = new float[half];
        float[] arr2 = new float[half];

        long a = System.currentTimeMillis();

        //From arr index 0 to arr1 indexes 0-half
        System.arraycopy(arr, 0, arr1, 0, half);
        //From arr index half to arr2 indexes 0-half
        System.arraycopy(arr, half, arr2, 0, half);

        Thread t1 = new Thread(() -> fillNewly(arr1));
        Thread t2 = new Thread(() -> fillNewly(arr2));

        t1.start();
        t2.start();

        //The join() method will keep waiting if the referenced thread is
        //blocked or is taking too long to process.

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Conjunction
        System.arraycopy(arr1, 0, arr, 0, half);
        System.arraycopy(arr2, 0, arr, half, half);

        System.out.println("Converted with threads:");
        System.out.println(System.currentTimeMillis() - a);
    }
    private void fillNewly(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

}
