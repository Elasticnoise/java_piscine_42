package com.company;

import java.util.UUID;

/*
    + Lazy initialization.
    + Thread safety;
 */

public class UserIdsGenerator {
    private static UserIdsGenerator INSTANCE;
    private Integer lastId = 0;

    private UserIdsGenerator() {}

    public Integer generateId() {
         lastId++;
         if (lastId == Integer.MAX_VALUE)
             lastId = 0;
         return lastId;
    }

    public static UserIdsGenerator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserIdsGenerator();
        }
        return INSTANCE;
    }
}
