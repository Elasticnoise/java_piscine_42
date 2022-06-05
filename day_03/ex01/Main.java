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

            Thread eggThread = new Thread(egg);
            Thread henThread = new Thread(hen);

            eggThread.start();
            henThread.start();

            joinThread(eggThread);
            joinThread(henThread);
        }
        else {
            System.out.println("Error: arguments.");
        }
    }
}
