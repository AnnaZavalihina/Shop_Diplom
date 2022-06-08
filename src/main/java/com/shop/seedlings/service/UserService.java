package com.shop.seedlings.service;

import com.shop.seedlings.domain.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(int id);
    List<User> getAllUsers();
    void saveUser(User user);
    void deleteUser(int id);
}
