package chadchat.domain;

public interface UserRepository {
    Iterable<User> findAllUsers();
    User createUser(User user);
}
