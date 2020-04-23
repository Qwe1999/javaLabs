package com.company;


public class Conflict {
    private final String name;
    private static boolean wait = false;

    public Conflict(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized void bow(Conflict bower){
        while (wait){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        wait=true;
        System.out.format("%s: %s пропускає мене ! %n",
                this.name,bower.getName());
        bower.bowBack(this);

        wait= false;
        notifyAll();

    }

    public synchronized void bowBack(Conflict bower){

        System.out.format("%s: %s пропускає мене у відповідь ! %n",
                this.name,bower.getName());
    }
}

