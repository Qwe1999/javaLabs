package com.company;

public class Main {
    public static  boolean wait = false;
    public static Object lock = new Object();
    public static void main(String[] args) {
        new Main().logic();
    }

    synchronized public void  logic(){
        Conflict conflict1 = new Conflict("Name 1");
        Conflict conflict2 = new Conflict("Name 2");


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                synchronized (lock){
                    try {
                        lock.wait();
                        conflict1.bow(conflict2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                synchronized (lock){
                    conflict2.bow(conflict1);
                    lock.notify();
                }
            }
        });
        thread1.start();
        thread2.start();
    }

}
