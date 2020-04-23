package com.company;

import static java.lang.Thread.sleep;

public class Counter2 {
    private int c = 0;

    public  void increment() throws InterruptedException {
        int a;
        synchronized (this){
        a=c;
        a++;
        sleep(100);
        c=a;
        }
    }

    public void decrement() throws InterruptedException {
        int a;
        synchronized (this){
            a=c;
            a--;
            sleep(100);
            c=a;
        }
    }

    public int value() {
        return c;
    }
}
