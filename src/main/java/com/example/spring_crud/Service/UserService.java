package com.example.spring_crud.Service;

import com.example.spring_crud.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getUsers();

    User getUser(Integer id);

    void updateUser(Integer id, User user);

    void deletUser(Integer id);
}
