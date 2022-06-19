package edu.school21.chat.models;

import java.util.List;
import java.util.UUID;

public class Chatroom {
    private long id;
    private String name;
    private String owner;
    private List<Message> messageList;

    public Chatroom(int id, String name, String owner, List<Message> messageList) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.messageList = messageList;
    }
}
