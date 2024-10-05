package com.example.spring_crud.Service.Impl;

import com.example.spring_crud.Service.UserService;
import com.example.spring_crud.entity.User;
import com.example.spring_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        User user=userRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"invalid User id"+id));
        return user;
    }

    @Override
    public void updateUser(Integer id, User user) {
       userRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"invalid User id"+id));

       user.setId(id);
       userRepository.save(user);
    }

    @Override
    public void deletUser(Integer id) {
       User user= userRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"invalid User id"+id));

       userRepository.delete(user);



    }
}
