package chadchat.domain;

import java.sql.Timestamp;

public class User {
    private final int id;
    private final String userName;
    private final Timestamp timestamp;


    public User(int id, String userName, Timestamp timestamp) {
        this.id = id;
        this.userName = userName;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Timestamp getTimestamp() {
         return timestamp;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + userName + '\'' +
                ", createdAt=" + timestamp +
                '}';
    }
}
