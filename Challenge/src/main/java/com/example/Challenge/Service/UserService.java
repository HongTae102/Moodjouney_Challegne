package com.example.Challenge.Service;

import com.example.Challenge.Dto.LoginDTO;
import com.example.Challenge.Dto.UserDTO;
import com.example.Challenge.Entity.User;
import com.example.Challenge.response.LoginResponse;
import java.util.List;
import java.util.Map;

public interface UserService {
    String addUser(UserDTO userDTO);
    LoginResponse loginUser(LoginDTO loginDTO);
    void deleteUser(int id);
    User getUserById(int id);
    boolean updateUser(int id, UserDTO userDTO);
    boolean partialUpdateUser(int id, Map<String, Object> updates);
    List<User> getAllUsers();
}
