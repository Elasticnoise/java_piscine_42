package com.company;

public class GenerateRunThreads {

    public static RunThread[] generatorRunThread(int countThreads, int step, int[] array) {
        RunThread[] runThreadsArray = new RunThread[countThreads];
        int start = 0;
        int end = step;

        for (int i = 0; i < countThreads; i++) {
            if (i < countThreads - 1) {
                runThreadsArray[i] = new RunThread(start, end, array);
                start += step;
                end += step;
            }
            else {
                end += (array.length % countThreads);
                runThreadsArray[i] = new RunThread(start, end, array);
            }

        }

        return runThreadsArray;
    }

    public static void startThreads(RunThread[] runThreadsArray) {
        Thread[] threadsArray = new Thread[runThreadsArray.length];

        for (int i = 0; i < runThreadsArray.length; i++)
            threadsArray[i] = new Thread(runThreadsArray[i]);

        for (Thread thread : threadsArray)
            thread.start();
    }
}
