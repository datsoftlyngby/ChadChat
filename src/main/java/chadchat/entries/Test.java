package chadchat.entries;

import chadchat.api.ChadChat;
import chadchat.domain.Message.Message;

import java.time.LocalDateTime;

public class Test implements Runnable, ChadChat.MessageObserver {
    private final String name;
    private final ChadChat chadChat;
    private LocalDateTime lastChecked;

    public Test(String name, ChadChat chadChat) {
        this.name = name;
        this.chadChat = chadChat;
    }

    @Override
    public void run() {
        chadChat.createMessage(null, "hello");
    }

    @Override
    public void notifyNewMessages() {
        for (Message m : chadChat.getNewMessages(lastChecked)) {
            System.out.println(this.name + " " + m);
        }
        lastChecked = LocalDateTime.now();
    }

    public static void main(String[] args) {
        ChadChat chadChat = new ChadChat();
        Test test1 = new Test("Test1", chadChat);
        Test test2 = new Test("Test2", chadChat);
        chadChat.registerMessageObserver(test1);
        chadChat.registerMessageObserver(test2);

        test1.run();
    }

}
