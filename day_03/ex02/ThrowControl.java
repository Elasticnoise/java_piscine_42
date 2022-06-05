package com.company;

public class ThrowControl {
    private int flag = 1;

    public synchronized void printing(String name) {
        if (name.equals("Hen")) {
            while (flag == 1)
                waiting();
            flag = 1;
        }
        else {
            while (flag == 0)
                waiting();
            flag = 0;
        }
        System.out.println(name);
        notify();
    }

    private void waiting() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
