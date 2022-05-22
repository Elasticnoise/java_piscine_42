package com.company;

public interface UserList {
    void addUser(User user);
    User getUserById(Integer id);
    User getUserByIndex(Integer index);
    Integer getCount();
}
