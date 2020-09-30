package chadchat.api;

import chadchat.domain.Message;
import chadchat.domain.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChadChat {
    private final Set<MessageObserver> messageObservers = new HashSet<>();
    private final List<Message> messages = new ArrayList<>();

    public void createMessage(User user, String message) {
        // Create message correctly.
        Message msg = new Message(message);
        messages.add(msg);

        synchronized (this) {
            for (MessageObserver messageObserver : messageObservers) {
                messageObserver.notifyNewMessages(msg);
            }
        }
    }

    public Iterable<Message> getNewMessages(LocalDateTime after) {
        // Database get messages
        return List.of(new Message("message"));
    }

    public synchronized void registerMessageObserver(MessageObserver observer) {
        messageObservers.add(observer);
    }

    public interface MessageObserver {
        void notifyNewMessages(Message msg);
    }

}
