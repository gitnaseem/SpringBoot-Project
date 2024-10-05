package com.example.spring_crud.controller;

import com.example.spring_crud.Service.UserService;
import com.example.spring_crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public  String addUser(@RequestBody User user){
        userService.addUser(user);

        return "Success add User";
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/get")
    public User getUser(@RequestParam Integer id){
        return userService.getUser(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Integer id,@RequestBody User user){
        userService.updateUser(id,user);

        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/delet/{id}")
    public ResponseEntity<Void> deletUser(@PathVariable Integer id){
        userService.deletUser(id);

        return ResponseEntity.noContent().build();
    }



}
