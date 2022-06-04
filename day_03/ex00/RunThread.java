package com.company;

public class RunThread implements Runnable {
    Integer count;
    String name;

    RunThread(Integer count, String name) {
        this.count = count;
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(name);
            sleeping(10);
        }
    }

    private static void sleeping(Integer milliSec) {
        if (milliSec < 0)
            return;
        try {
            Thread.sleep(milliSec);
        } catch (InterruptedException e) {
            System.out.println("Interrupt");
        }
    }
}
