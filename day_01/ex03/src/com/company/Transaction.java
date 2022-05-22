package com.company;

import java.util.UUID;

public class Transaction {
    private UUID    identifier;
    private User    recipient;
    private User    sender;
    private Type    transferCategory;
    private Integer transfer_amount;

    enum Type {
        CREDIT,
        DEBIT,
    }

    public Transaction(User recipient, User sender, Integer transfer_amount) {
        this.recipient = recipient;
        this.sender = sender;
        this.transfer_amount = transfer_amount;

        if (transfer_amount >= 0)
            this.transferCategory = Type.DEBIT;
        else
            this.transferCategory = Type.CREDIT;
        identifier = UUID.randomUUID();
        sender.setBalance(sender.getBalance() - transfer_amount);
        recipient.setBalance(recipient.getBalance() + transfer_amount);
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Integer getTransfer_amount() {
        return transfer_amount;
    }

    public void setTransfer_amount(Integer transfer_amount) {
        this.transfer_amount = transfer_amount;
    }

    public static Transaction createTransaction(User recipient, User sender, Type transferCategory, Integer transfer_amount) {
        if ((transferCategory == Type.CREDIT && transfer_amount < 0 && recipient.getBalance() >= -transfer_amount)
                || (transferCategory == Type.CREDIT && transfer_amount > 0 && sender.getBalance() >= transfer_amount)) {
            return new Transaction(recipient, sender, transfer_amount);
        }
        else
            System.out.println("Transaction cannot be created");
        return null;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "identifier=" + identifier +
                ", recipient=" + recipient +
                ", sender=" + sender +
                ", transferCategory=" + transferCategory +
                ", transfer_amount=" + transfer_amount +
                '}';
    }
}



