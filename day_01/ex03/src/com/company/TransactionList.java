package com.company;

import java.util.UUID;

public interface TransactionList {
    void add(Transaction transaction);
    Transaction remove(UUID id);
    Transaction[] toArray();
}
