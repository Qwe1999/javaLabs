package com.company;


import static java.lang.Thread.sleep;

class ChickenVoice {

    static EggVoice  mAnotherOpinion;

    public static void main(String[] args) {

        mAnotherOpinion = new EggVoice();
        Thread thread = new Thread(new EggVoice());
        System.out.println("Початок суперечки");
        thread.start();

        for (int i = 0; i <5 ; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Курка");
        }
            if (thread.isAlive()){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Першим було яйце");
            }
            else {
                System.out.println("Першою була курка");
            }
            System.out.println("Завершення суперечки");

    }

}
