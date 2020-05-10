package com.company;

import static java.lang.Thread.sleep;

public class EggVoice implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("яйце");
        }
    }
}
