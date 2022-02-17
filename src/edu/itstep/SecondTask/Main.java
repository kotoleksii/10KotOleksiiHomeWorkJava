package edu.itstep.SecondTask;


public class Main {
    public static void main(String[] args) {
        CounterThread counter = new CounterThread();

        Thread thread1 = new Thread(counter);
        Thread thread2 = new Thread(counter);

        thread1.start();
        thread2.start();
    }
}
