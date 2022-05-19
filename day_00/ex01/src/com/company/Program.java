package com.company;
import java.util.Scanner;

public class Program {

    private static int calcSqrt(int inputNumber) {

        long begin = 1;

        long end = inputNumber;

        long middle;

        long result = 0;

        while (begin <= end) {
            middle = (begin + end) / 2;
            if (middle * middle == inputNumber) {
                return ((int) middle);
            } else if (middle * middle < inputNumber) {
                begin = middle + 1;
                result = middle;
            } else {
                end = middle - 1;
            }
        }

        return (int) result;
    }

    public static void main(String[] args) {
        boolean isPrime = false;
        int i = 1;
        Scanner in = new Scanner(System.in);
        System.out.print("-> ");
        int num = in.nextInt();

        if (num <= 1){
            System.out.println("Illegal Argument");
            System.exit(-1);
        }
        if (num % 2 == 0 && num != 2) {
            System.out.println(isPrime + " " + i);
            System.exit(0);
        }
        for (i = 2; i <= calcSqrt(num); i++) {
            if (num % i == 0) {
                System.out.println(isPrime + " " + i);
                System.exit(0);
            }
        }
        isPrime = true;
        System.out.println(isPrime + " " + i);
        in.close();
    }
}
