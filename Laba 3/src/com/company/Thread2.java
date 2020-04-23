package com.company;

public class Thread2 implements Runnable {

    Conflict conflict1;
    Conflict conflict2;

    public Thread2(Conflict conflict1, Conflict conflict2) {
        this.conflict1 = conflict1;
        this.conflict2 = conflict2;
    }

    public Conflict getConflict1() {
        return conflict1;
    }

    public Conflict getConflict2() {
        return conflict2;
    }

    @Override
    public void run() {
        conflict2.bow(conflict1);
    }
}
