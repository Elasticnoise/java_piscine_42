package com.company;

public class CheckArgs {
    private final String argValue;

    CheckArgs(String argValue) {
        this.argValue = argValue;
    }

    public static boolean isOneArg(String[] args) {
        return args.length == 1;
    }

    public static boolean isValidArg(String[] args) {
        String[] splitArg;

        splitArg = args[0].split("=");
        return args[0].equals("--count");
    }
}
