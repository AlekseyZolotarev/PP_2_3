package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUser(int id);

    void saveUser(User user);

    void editUser(int id, User user);

    void deleteUser(int id);
}
