package com.company;

public class Voice extends Thread {
    public String name;

    public Voice(String name) {
        this.name = name;
    }

    @Override
    public  void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name);
            }
    }
}
