package com.company;

import static java.lang.Thread.sleep;

public class Counter{
    private int c = 0;

    public synchronized void increment() throws InterruptedException {
        int a;
        a=c;
        a++;
        sleep(100);
        c=a;
    }

    public synchronized void decrement() throws InterruptedException {
        int a;
        a=c;
        sleep(100);
        a--;
        c=a;
    }

    public int value() {
        return c;
    }
}
