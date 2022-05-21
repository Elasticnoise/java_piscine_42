package com.company;

public class Program {

    public static void main(String[] args) {
        User first = new User("First", 100);
        User second = new User("Second", 200);
        UsersArrayList usersArrayList = new UsersArrayList();

        usersArrayList.addUser(first);
        usersArrayList.addUser(second);
        System.out.println(usersArrayList);
        System.out.println(usersArrayList.getCount());

        System.out.println(usersArrayList.getUserByIndex(1));
        System.out.println(usersArrayList.getUserById(1));
        System.out.println("----------------------------------");

        System.out.println("Search for a non-existent user");
//        System.out.println(usersArrayList.getUserByIndex(11));
        System.out.println(usersArrayList.getUserById(16));

    }
}
