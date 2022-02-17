package edu.itstep.SecondTask;

public class CounterThread implements Runnable {
    public static int count = 0;
    int step = 1_000;
    int tmp = count + step;

    @Override
    synchronized public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
            if (count == tmp) {
                try {
                    tmp += step;
                    notify();
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        notifyAll();
    }
}
