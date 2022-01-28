package com.spring.SurveyStorage.service;

import com.spring.SurveyStorage.entity.User;
import com.spring.SurveyStorage.repository.ActUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public User getUser(int id) {
        User survey = null;
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            survey = optional.get();
        }
        return survey;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
