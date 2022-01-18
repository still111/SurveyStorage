package com.spring.SurveyStorage.service;

import com.spring.SurveyStorage.entity.User;
import com.spring.SurveyStorage.repository.ActUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final ActUserRepository userRepository;

    public UserServiceImp(ActUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
