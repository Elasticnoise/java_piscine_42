package com.company;

import java.util.Scanner;

public class Program {
    private static final int MAX_WEEKS = 18;
    private static final String END_PROGRAM = "42";

    private static int getRazryad(long grades) {
        int razryad = 1;
        int i = 0;
        while (grades > 0) {
            grades /= 10;
            i++;
        }
        for (; i > 1; --i)
            razryad *= 10;
        return razryad;
    }

    private static void getStat(long current_grade, int current_week)
    {
        System.out.print("Week " + current_week + " ");
        while (current_grade > 0) {
            System.out.print("=");
            current_grade--;
        }
        System.out.println(">");
    }

    private static void printGrades(long grades) {
        int count_week = 1;
        while (grades != 0) {
            long current_grade = grades / getRazryad(grades);
            getStat(current_grade, count_week);
            grades -= current_grade * getRazryad(grades);
            count_week++;
        }
    }

    private static int getMinGrade() {
        Scanner in = new Scanner(System.in);
        System.out.print("-> ");
        int grade = in.nextInt();
        int min_grade = 9;

        for (int j = 0; j < 5; j++) {
            if (grade < 1 || grade > 9) {
                System.out.println("Illegal Argument");
                System.exit(-1);
            }
            if (grade < min_grade)
                min_grade = grade;
            if (j != 4)
                grade = in.nextInt();
        }
        return min_grade;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long    grades = 0;

        System.out.print("-> ");
        String week = in.nextLine();
	    for (int i = 1; i <= MAX_WEEKS; i++) {
            if (week.equals(END_PROGRAM))
                break;
            if (!week.endsWith(String.valueOf(i))) {
                System.out.println("Illegal Argument");
                System.exit(-1);
            }
            grades += getMinGrade();
            grades *= 10;
            System.out.print("-> ");
            week = in.nextLine();
        }
        grades /= 10;
        printGrades(grades);
    }
}
