package com.company;

public class Main {

    private static  void joinThread(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (!CheckArgs.isValidArg(args) && CheckArgs.isOneArg(args)) {
            String[] splitArg = args[0].split("=");
            Integer count = Integer.valueOf(splitArg[1]);
            RunThread egg = new RunThread(count, "Egg");
            RunThread hen = new RunThread(count, "Hen");
            RunThread human = new RunThread(count, "Human");

            Thread eggThread = new Thread(egg);
            Thread henThread = new Thread(hen);
            Thread humanTread = new Thread(human);

            eggThread.start();
            henThread.start();

            joinThread(eggThread);
            joinThread(henThread);

            humanTread.start();

            joinThread(humanTread);
        }
        else {
            System.out.println("Error: arguments.");
        }
    }
}
