package chadchat.domain;

public class Message {
    private final String message;

    public Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                '}';
    }
}
