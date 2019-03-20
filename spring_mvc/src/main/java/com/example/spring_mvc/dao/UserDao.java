package com.example.spring_mvc.dao;

import com.example.spring_mvc.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    User getUser(Long id);
    User insertUser(User user);
    int updateUser(User user);
    List<User> findUsers(@Param("userName") String userName, @Param("note") String note);
    int deleteUser(Long id);
}