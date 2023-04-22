package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.entity.User;
import com.bootcamp.springboot.exception.UserPersistException;
import com.bootcamp.springboot.exception.UserRequestException;
import com.bootcamp.springboot.interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserInterface service;

    @Autowired
    public UserController(UserInterface service) {
        this.service = service;
    }

    //Find All Users
    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getUsers() {
        try {
            List<User> users = service.findAllUser();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (UserRequestException e) {
            throw new UserRequestException(e.getMessage());
        }

    }

    //Find One User by id
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        try {
            User user = service.findUser(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserRequestException e) {
            throw new UserRequestException(e.getMessage());
        }

    }

    //Create User
    @PostMapping("/create/user")
    public ResponseEntity<User> create(@RequestBody User user) {
        try {
            service.create(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserPersistException e) {
            throw new UserPersistException(e.getMessage());
        }

    }

    //Update User name by ID
    @PutMapping("/user/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable Integer id, @RequestBody User user) {
        try {
            user.setId(id);
            service.update(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserPersistException e) {
            throw new UserPersistException(e.getMessage());
        }

    }

    //Delete User by ID
    @DeleteMapping("/user/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserPersistException e) {
            throw new UserPersistException(e.getMessage());
        }

    }
}
