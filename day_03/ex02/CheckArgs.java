package com.company;

public class CheckArgs {

    public static boolean isOneArg(String[] args) {
        return args.length == 2;
    }

    public static boolean isValidArg(String[] args) {
        String[] splitArg;

        splitArg = args[0].split("=");
        if (!splitArg[0].equals("--arraySize"))
        {
            System.out.println(splitArg[0]);
            return false;
        }
        splitArg = args[1].split("=");
        if ((!splitArg[0].equals("--threadsCount"))
                || Integer.parseInt(splitArg[1]) > 2000000)
        {
            System.out.println(splitArg[0]);
            return false;
        }
        return true;
    }
}
