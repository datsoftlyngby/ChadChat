package chadchat.ui;

import chadchat.domain.User;
import chadchat.domain.UserRepository;
import chadchat.infrastructure.Database;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Protocol {

    //ChadChat chadchat = ChadChat.getInstance();

    private Scanner in;
    private PrintWriter out;

    public Protocol(Scanner in, PrintWriter out) throws IOException {
        this.in = in;
        this.out = out;
    }

    public void run(User user) throws ClassNotFoundException {
        Database d = new Database();
        String userName = user.getName();

        out.println("Welcome to the General chatroom: " + userName + "\nIn this room there are: \n" + d.findAllUsers());
        out.flush();

        String line;
        while (!(line = in.next()).equals("exit")) {
            out.println(userName + ">" + line);
            out.flush();
        }
    }

    public void makeUserAndRun() throws ClassNotFoundException {
        Database d = new Database();
        String line;
        getLoginScreen();
        while (!(line = in.next()).equals("exit")) {
            switch (line) {
                case "l":
                case "login":
                    //login();
                    break;
                case "s":
                case "signup":
                    out.println("What do we call you: ");
                    out.flush();
                    String userName = in.next();
                    User userbefore = User.createUser(userName);
                    User userafter = d.createUser(userbefore);
                    run(userafter);
                    break;
                default: out.println("Ugyldigt input");
                    out.flush();
            }
        }
    }

    private void getLoginScreen() {
        out.println("Welcome to the chatroom! " +
                    "\nIf you are a new user write: [s]ignup" +
                    "\nIf you are a returning user: [l]ogin");
        out.flush();
    }
}
