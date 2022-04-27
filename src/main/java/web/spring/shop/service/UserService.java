package web.spring.shop.service;

import web.spring.shop.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(int id);
    List<User> getAllUsers();
    void saveUser(User user);
    void deleteUser(int id);
}
