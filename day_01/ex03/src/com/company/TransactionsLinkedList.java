package com.company;

import java.util.UUID;

class TransactionNotFoundException extends RuntimeException {}

public class TransactionsLinkedList implements TransactionList {
    private Node start;
    private Node end;
    private Integer count;

    public TransactionsLinkedList() {
        start = new Node(null);
        end = new Node(null);

        start.next = end;
        end.prev = start;
        count = 0;
    }

    private Node first() {
        return start.next();
    }

    @Override
    public void add(Transaction transaction) {
        (new Node(transaction)).pushBack(end);
        count++;
    }

    @Override
    public Transaction remove(UUID uuid) {
        Node node = first();
        while (node != end) {
            if (uuid.equals(node.getTransaction().getIdentifier())) {
                node.cut();
                count--;
                return node.getTransaction();
            }
            node = node.next();
        }
        throw new TransactionNotFoundException();
    }

    public Transaction[] toArray() {
        Transaction[] transactions = new Transaction[count];

        Node node = first();
        for (int i = 0; i < count; i++) {
            node = node.next();
            transactions[i] = node.getTransaction();
        }
        return transactions;
    }

    private class Node {
        private Transaction transaction;
        private Node next;
        private Node prev;

        public Node(Transaction transaction) {
            this.transaction = transaction;
        }

        public void pushBack(Node end) {
            prev = end.prev;
            prev.next = this;
            end.prev = this;
            next = end;
        }

        public void cut() {
            next.prev = prev;
            prev.next = next;
            next = null;
            prev = null;
        }

        public Transaction getTransaction() {
            return transaction;
        }

        public Node next() {
            return next;
        }
    }
}
