package edu.itstep.FirstTaskSynchronized;

public class Main {
    public static void main(String[] args) {
        Object object = new Object();

        Thread thread1 = new Thread(new CounterThread(object));
        Thread thread2 = new Thread(new CounterThread(object));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(CounterThread.count);
    }
}
