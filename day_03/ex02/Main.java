package com.company;

import java.lang.reflect.Array;

public class Main {

    private static  void joinThread(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static  void threadsCounter(Thread[] threads) {

    }

    private static int[] arrayGenerator(Integer len) {
        int[] array = new int[len];

        for (int i = 0; i < array.length; i++) {
//            array[i] = (int) (Math.random() * 1000);
            array[i] = 1;
        }

        return array;
    }

    public static void main(String[] args) {
        if (CheckArgs.isValidArg(args) && CheckArgs.isOneArg(args)) {
            int arrSize = Integer.parseInt(args[0].split("=")[1]);
            System.out.println("Sum: " + arrSize);
            int countThreads = Integer.parseInt(args[1].split("=")[1]);
            int step = arrSize / countThreads;
            int[] array = arrayGenerator(arrSize);

            GenerateRunThreads.startThreads(GenerateRunThreads.generatorRunThread(countThreads, step, array));

//            Thread[] threads = new Thread[countThreads];
//            for (int j : array) System.out.println(j);
            System.out.println("Correct work!");
        }
        else {
            System.out.println("Error: arguments.");
        }
    }
}
