package com.rakib.springdataredis.service;

import com.rakib.springdataredis.entity.User;
import com.rakib.springdataredis.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        System.out.println("Called From DB");
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("User not found with id: " + id));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
