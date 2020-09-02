package com.example.managerterasua.controller;

import com.example.managerterasua.model.JwtResponse;
import com.example.managerterasua.model.Role;
import com.example.managerterasua.model.User;
import com.example.managerterasua.service.IRole;
import com.example.managerterasua.service.IUser;
import com.example.managerterasua.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
public class UserController {

    @Autowired
    private IUser userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IRole roleService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.findByUsername(user.getUsername());
        return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), currentUser.getUsername(), userDetails.getAuthorities()));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        Set<Role> roles = new HashSet<>();
        List<User> userList = (List<User>) userService.findAll();
        for (User u : userList) {
            if (u.getUsername().equals(user.getUsername())) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        Role role = roleService.findByName("ROLE_USER");
        roles.add(role);
        user.setRoles(roles);
        String password = user.getPassword();
        String encoderPassword = new BCryptPasswordEncoder().encode(password);
        user.setPassword(encoderPassword);
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
