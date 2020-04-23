package com.company;

public class Main implements Runnable{

    static Counter counter;
    static Counter2 counter2;
    public static void main(String[] args) throws InterruptedException {
        counter = new Counter();
        counter2 = new Counter2();

        Thread thread1 = new Thread(new Main());
        thread1.start();
        Thread thread2 = new Thread(new Main());
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter2.value());
    }

    @Override
    public void run() {
        try {
            counter2.increment();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
