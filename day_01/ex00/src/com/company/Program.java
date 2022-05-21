package com.company;

public class Program {

    public static void main(String[] args) {
        User first = new User(1, "Bob", 300);
        User second = new User(2, "Tom", 500);

        System.out.println(first);
        System.out.println(second);

        Transaction transaction1 = Transaction.createTransaction(second, first, Transaction.Type.CREDIT, -100);
        System.out.println(transaction1);

        System.out.println("---------------------------------------------------");

        User third = new User(3, "Ernest", -200);
        System.out.println(third);

        System.out.println("---------------------------------------------------");

        User Bum1 = new User(4, "Bum", 0);
        User Bum2 = new User(4, "Bum", 0);
    }
}