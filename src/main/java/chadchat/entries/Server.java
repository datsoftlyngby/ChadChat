package chadchat.entries;

import chadchat.domain.User;
import chadchat.domain.UserRepository;
import chadchat.infrastructure.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Server {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserRepository d = new Database();
        User before = User.createUser("Big Gray");
        User after = d.createUser(before);
        System.out.println("before: " + before + " after: " + after);
        System.out.println(d.findAllUsers());
    }




}
