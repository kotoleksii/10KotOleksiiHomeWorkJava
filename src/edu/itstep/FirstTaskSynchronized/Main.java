package edu.itstep.FirstTaskSynchronized;

public class Main {
    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();

        Thread thread1 = new Thread(new CounterThread(commonResource));
        Thread thread2 = new Thread(new CounterThread(commonResource));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(CommonResource.count);
    }
}
