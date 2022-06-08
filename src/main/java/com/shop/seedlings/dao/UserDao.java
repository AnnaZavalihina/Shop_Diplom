package com.shop.seedlings.dao;

import com.shop.seedlings.domain.entity.User;

import java.util.List;

public interface UserDao {
        User getUserById(int id);
        List<User> getAllUsers();
        void saveUser(User user);
        void deleteUser(int id);
    }