package com.company;


public class Main extends Thread{



    public static void main(String[] args) {
        new Main().run();
    }

    public void run(){
        Voice voice1 = new Voice("Курка");
        Voice voice2 = new Voice("Яйце");
        System.out.println("Початок суперечки");

        voice1.start();
        voice2.start();

        while (voice1.isAlive() ){
                try {
                    voice1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        if(voice2.isAlive()){
            try {
                voice2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Першим було яйце");
        }
        else {
            System.out.println("Першим була курка");
        }
        System.out.println("Завершення суперечки");
    }

}
