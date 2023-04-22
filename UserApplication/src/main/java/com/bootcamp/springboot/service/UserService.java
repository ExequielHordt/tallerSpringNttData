package com.bootcamp.springboot.service;

import com.bootcamp.springboot.entity.User;
import com.bootcamp.springboot.exception.UserPersistException;
import com.bootcamp.springboot.exception.UserRequestException;
import com.bootcamp.springboot.interfaces.UserInterface;
import com.bootcamp.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserInterface {
    @Autowired
    private UserRepository repository;

    //Create User
    @Transactional
    public void create(User user) {
        try {
            if (user.getName() == null || user.getName().trim().isEmpty()) {
                throw new UserPersistException("Debe indicar un nombre");
            }
            if (user.getBirthDate() == null) {
                throw new UserPersistException("Debe indicar una fecha de nacimiento");
            }
            repository.save(user);
        } catch (UserPersistException e) {
            throw new UserPersistException(e.getMessage());
        }

    }

    //Update User by User id
    @Transactional
    public void update(User user) {
        try {
            Optional<User> findUser = repository.findById(user.getId());
            if (findUser.isPresent()) {
                User existingUser = findUser.get();
                if (user.getName() != null && !user.getName().trim().isEmpty()) {
                    existingUser.setName(user.getName());
                }
                if (user.getBirthDate() != null) {
                    existingUser.setBirthDate(user.getBirthDate());
                }
                repository.save(existingUser);
            } else {
                throw new UserPersistException("El usuario con id " + user.getId() + " no se encuentra en nuestra base de datos");
            }
        } catch (UserPersistException e) {
            throw new UserPersistException(e.getMessage());
        }
    }

    //Delete User by id
    @Transactional
    public void delete(Integer id) {
        try {
            User user = findUser(id);
            repository.delete(user);
        } catch (UserPersistException e) {
            throw new UserPersistException(e.getMessage());
        }
    }

    //Find one User by id
    public User findUser(Integer id) {
        try {
            User user = repository.findUser(id);
            if (user == null) {
                throw new UserRequestException("An unexpected error ocurred");
            }
            return user;
        } catch (UserRequestException e) {
            throw new UserRequestException(e.getMessage());
        }

    }

    //Find all User
    public List<User> findAllUser() {
        try {
            List<User> users = new ArrayList<User>();
            users = repository.findAll();
            if (users == null) {
                throw new UserRequestException("An unexpected error ocurred");
            }
            return users;
        } catch (UserRequestException e) {
            throw new UserRequestException(e.getMessage());
        }
    }
}
