package com.backend.athletica.service;

import com.backend.athletica.entity.User;
import com.backend.athletica.entity.UserRequest;
import com.backend.athletica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRequest userRequest) {
        if (userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
            throw new IllegalArgumentException("user already exists");
        }

        User user = new User(
                userRequest.getNickname(),
                userRequest.getFirstname(),
                userRequest.getLastname(),
                userRequest.getEmail(),
                new BCryptPasswordEncoder(12).encode(userRequest.getPassword()));

        User saved = userRepository.save(user);

        return saved;
    }

    @Override
    public User getOne(String email) {
        return userRepository.findByEmail(email).
                orElseThrow(() -> new UsernameNotFoundException("email not found: " + email));
    }

    @Override
    public User getOneById(Long id, String newUsername) {
        User user = userRepository.findById(id).get();
        user.setNickname(newUsername);
        return userRepository.save(user);
    }
}