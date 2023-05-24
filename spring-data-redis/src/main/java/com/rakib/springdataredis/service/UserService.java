package com.rakib.springdataredis.service;

import com.rakib.springdataredis.entity.User;

public interface UserService {

    User saveUser(User user);
    User getUserById(Long id);
    void deleteUser(Long id);
}
