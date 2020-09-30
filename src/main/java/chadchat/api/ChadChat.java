package chadchat.api;

import chadchat.domain.Message.Message;
import chadchat.domain.User;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChadChat {
    private final Set<MessageObserver> messageObservers = new HashSet<>();

    public void createMessage(User user, String msg) {
        // Create message correctly.
        synchronized (this) {
            for (MessageObserver messageObserver : messageObservers) {
                messageObserver.notifyNewMessages();
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
        void notifyNewMessages();
    }

}
