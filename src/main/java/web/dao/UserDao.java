package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers(String sql);

    User getUser(int id);

    void saveUser(User user);

    void editUser(int id, User user);

    void deleteUser(int id);
}
