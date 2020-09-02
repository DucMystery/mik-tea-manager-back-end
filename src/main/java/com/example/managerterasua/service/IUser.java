package com.example.managerterasua.service;

import com.example.managerterasua.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUser extends GenericService<User>, UserDetailsService {
    User findByUsername(String username);
}
