package edu.itstep.FirstTaskSynchronized;

public class CounterThread implements Runnable {
    CommonResource commonResource;

    CounterThread(CommonResource commonResource) {
        this.commonResource = commonResource;
    }

    public void run() {
        commonResource.increment();
    }
}
