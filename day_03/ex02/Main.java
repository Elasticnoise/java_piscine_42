package com.company;


public class Main {

    private static int[] arrayGenerator(Integer len) {
        int[] array = new int[len];

        for (int i = 0; i < array.length; i++)
            array[i] = (int) (Math.random() * 1000);

        return array;
    }

    private static int getArraySum(int[] array) {
        int sum = 0;
        for (int j : array) sum += j;
        return sum;
    }

    public static void main(String[] args) {
        if (CheckArgs.isValidArg(args) && CheckArgs.isOneArg(args)) {
            int arrSize = Integer.parseInt(args[0].split("=")[1]);
            int countThreads = Integer.parseInt(args[1].split("=")[1]);
            int step = arrSize / countThreads;
            int[] array = arrayGenerator(arrSize);

            System.out.println("Sum: " + getArraySum(array));
            GenerateRunThreads.startThreads(GenerateRunThreads.generatorRunThread(countThreads, step, array));
        }
        else {
            System.out.println("Error: arguments.");
        }
    }
}
