package com.company;

import java.util.Scanner;

public class Program {

    private static final int MAX_CHAR_CODES = 65_535;
    private static final int MAX_TOP_CHARS = 10;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("-> ");
        String symbols = in.nextLine();
//        char[] char_line = symbols.toCharArray();
        System.out.println(symbols);
    }
}
