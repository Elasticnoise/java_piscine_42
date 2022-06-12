package com.company;

public class RunThread implements Runnable {
    Integer start;
    Integer end;
    Integer counter = 0;

    static Integer threadSumCounter = 0;
    int[] array;

    RunThread(Integer start, Integer end, int[] array) {
        this.start = start;
        this.end = end;
        this.array = array;
    }
    @Override
    public void run() {
        for (int i = start; i < end; i++)
            counter += array[i];

        threadSumCounter += counter;
        System.out.println("Thread " + "from " + (start+1) + " to " + end + " sum is " + counter);
        if (end == array.length)
            System.out.println("Sum by threads: " + threadSumCounter);
    }
}
