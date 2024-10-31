package com.backend.athletica.service;

import com.backend.athletica.entity.User;
import com.backend.athletica.entity.UserRequest;

public interface AuthService {
    User save(UserRequest user);

    User getOne(String email);

    User getOneById(Long id, String newUsername);
}
