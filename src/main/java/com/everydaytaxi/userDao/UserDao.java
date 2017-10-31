package com.everydaytaxi.userDao;

import com.everydaytaxi.models.User;

/**
 * Created by yeldos on 10/31/17.
 */
public interface UserDao {
    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int userId);

    void getUserList();

    User getUser(int userId);
}
