package com.company;

public class ChickenVoice extends  Thread{

    static EggVoice  mAnotherOpinion;

    public static void main(String[] args) {

        mAnotherOpinion = new EggVoice();
        System.out.println("Початок суперечки");
        mAnotherOpinion.start();

        for (int i = 0; i <5 ; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (mAnotherOpinion.isAlive()){
                try {
                    mAnotherOpinion.join();
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

}
