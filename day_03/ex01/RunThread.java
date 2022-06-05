package com.company;

public class RunThread implements Runnable {
    private static final ThrowControl throwControl = new ThrowControl();
    Integer count;
    String name;

    RunThread(Integer count, String name) {
        this.count = count;
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            throwControl.printing(this.name);
        }
    }
}
