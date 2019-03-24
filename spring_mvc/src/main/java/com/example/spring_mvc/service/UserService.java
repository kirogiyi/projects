package com.example.spring_mvc.service;

import com.example.spring_mvc.pojo.User;

import java.util.List;

public interface UserService {
    User getUser(Long id);
    int insertUser(User user);
    User updateUserName(Long id, String userName);
    List<User> findUsers(String userName, String note);
    int deleteUser(Long id);
}
