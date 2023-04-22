package com.bootcamp.springboot.interfaces;

import com.bootcamp.springboot.entity.User;


import java.util.List;

public interface UserInterface {
    public void create(User user);

    public void update(User user);

    public void delete(Integer id);

    public User findUser(Integer id);

    public List<User> findAllUser();
}
