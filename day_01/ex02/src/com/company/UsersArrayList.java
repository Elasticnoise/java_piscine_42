package com.company;

import java.util.Arrays;

class UserNotFoundException extends RuntimeException {}

public class UsersArrayList implements UserList {
    private static final Integer DEFAULT_SIZE = 10;

    private User[] arr;
    private Integer count;

    UsersArrayList() {
        this.arr = new User[DEFAULT_SIZE];
        this.count = 0;
    }

    public void addUser(User user) {
        if (arr.length == count) {
            User[] newArr = new User[(int) (count + (count * 0.5))];
            for (int i = 0; i < arr.length; i++)
                newArr[i] = arr[i];
            arr = newArr;
        }
        arr[count] = user;
        count++;
    }

    public User getUserById(Integer id) {
        for (User user : arr) {
            if (user != null && id.equals(user.getIdentifier()))
                return user;
        }
        throw new UserNotFoundException();
    }

    public User getUserByIndex(Integer index) {
        if (index < 0 || index > count)
            throw new UserNotFoundException();
        return arr[index];
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "UsersArrayList{" +
                "arr=" + Arrays.toString(arr) +
                ", count=" + count +
                '}';
    }
}
