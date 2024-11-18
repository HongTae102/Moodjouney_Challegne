package com.example.Challenge.Service.impl;

import com.example.Challenge.Dto.LoginDTO;
import com.example.Challenge.Dto.UserDTO;
import com.example.Challenge.Entity.User;
import com.example.Challenge.Repo.UserRepo;
import com.example.Challenge.Service.UserService;
import com.example.Challenge.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public String addUser(UserDTO userDTO) {
        if (userRepo.existsByEmail(userDTO.getEmail())) {
            return "User already exists";
        }
        User user = new User(
                userDTO.getId(),
                userDTO.getEname(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getMembership());
        userRepo.save(user);
        return "User added successfully";
    }

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        Optional<User> user = userRepo.findOneByEmailAndPassword(
                loginDTO.getEmail(),
                loginDTO.getPassword());
        if (user.isPresent()) {
            return new LoginResponse(true, "Login successful");
        }
        return new LoginResponse(false, "Invalid credentials");
    }

    @Override
    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public User getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public boolean updateUser(int id, UserDTO userDTO) {
        Optional<User> existingUser = userRepo.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setName(userDTO.getEname());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setMembership(userDTO.getMembership());
            userRepo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean partialUpdateUser(int id, Map<String, Object> updates) {
        Optional<User> existingUser = userRepo.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            if (updates.containsKey("name")) {
                user.setName((String) updates.get("name"));
            }
            if (updates.containsKey("email")) {
                user.setEmail((String) updates.get("email"));
            }
            if (updates.containsKey("password")) {
                user.setPassword((String) updates.get("password"));
            }
            if (updates.containsKey("membership")) {
                user.setMembership((int) updates.get("membership"));
            }
            userRepo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

}
