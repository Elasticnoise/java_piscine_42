package com.company;

public class RunThread implements Runnable {
    Integer start;
    Integer end;
    Integer counter = 0;
    int[] array;

    RunThread(Integer start, Integer end, int[] array) {
        this.start = start;
        this.end = end;
        this.array = array;
    }
    @Override
    public void run() {
        for (int i = start; i < end; i++)
        {
            counter += array[i];
        }
        System.out.println(counter);
    }
}
