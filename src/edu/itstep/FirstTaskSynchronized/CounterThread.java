package edu.itstep.FirstTaskSynchronized;

public class CounterThread implements Runnable {
    public static int count = 0;
    Object object;

    CounterThread(Object obj) {
        this.object = obj;
    }

    public void run() {
        synchronized (object) {
            for (int i = 0; i < 1_000_000; i++) {
                count++;
            }
        }
    }
}
