package edu.school21.chat.models;

import java.util.List;
import java.util.UUID;

public class User {
    private long id;
    private String login;
    String password;
    List<Chatroom> createdRooms;
    List<Chatroom> userSocializesRoom;

    public User(int id, String login, String password, List<Chatroom> createdRooms, List<Chatroom> userSocializesRoom) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.userSocializesRoom = userSocializesRoom;
    }
}
