package com.company;

public class Main {

    public static void main(String[] args) {
        Conflict conflict1 = new Conflict("Name 1");
        Conflict conflict2 = new Conflict("Name 2");


        Thread thread1 = new Thread(new Thread1(conflict1,conflict2));
        Thread thread2 = new Thread(new Thread2(conflict2,conflict1));
        thread1.start();
        thread2.start();

    }


}
