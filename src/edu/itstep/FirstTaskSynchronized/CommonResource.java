package edu.itstep.FirstTaskSynchronized;

public class CommonResource {
    public static int count = 0;

    synchronized void increment() {
        for (int i = 0; i < 1_000_000; i++) {
            count++;
        }
    }
}
