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

    private static boolean checkPrime(int num) {
        if (num <= 1)
            return false;
        if (num % 2 == 0 && num != 2)
            return false;
        for (int i = 2; i <= calcSqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private static int sumNumbers(int num) {
        int res = 0;

        while (num != 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("-> ");
        int num = in.nextInt();
        int countPrime = 0;

	    while (num != 42) {
            if (checkPrime(sumNumbers(num)))
                ++countPrime;
            System.out.print("-> ");
            num = in.nextInt();
        }
        System.out.print("Count of coffee-request – " + countPrime);
    }
}
