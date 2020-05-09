package com.company;

import static java.lang.Thread.sleep;

public class Counter2 {
    private int c1 = 0;
    private int c2 = 0;

    private Object lock1 = new Object();
    private Object lock2 = new Object();



    public  void increment1() throws InterruptedException {
        int a;
        synchronized (lock1){
        a=c1;
        a++;
        sleep(100);
        c1=a;
        }
    }

    public void decrement1() throws InterruptedException {
        int a;
        synchronized (lock1){
            a=c1;
            a--;
            sleep(100);
            c1=a;
        }
    }

    public  void increment2() throws InterruptedException {
        int a;
        synchronized (lock2){
            a=c2;
            a++;
            sleep(100);
            c2=a;
        }
    }

    public void decrement2() throws InterruptedException {
        int a;
        synchronized (lock2){
            a=c2;
            a--;
            sleep(100);
            c2=a;
        }
    }

    public int value1() {
        return c1;
    }

    public int value2() {
        return c2;
    }
}
