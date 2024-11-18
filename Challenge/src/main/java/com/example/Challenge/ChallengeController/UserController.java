package com.example.Challenge.ChallengeController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Challenge.Dto.LoginDTO;
import com.example.Challenge.Dto.UserDTO;
import com.example.Challenge.Entity.User;
import com.example.Challenge.Repo.UserRepo;
import com.example.Challenge.Service.UserService;
import com.example.Challenge.response.LoginResponse;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDTO userDTO) {
        String id = userService.addUser(userDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        boolean updated = userService.updateUser(id, userDTO);
        if (updated) {
            return ResponseEntity.ok("User updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping(path = "/update/{id}")
    public ResponseEntity<String> partialUpdateUser(@PathVariable int id,
            @RequestBody Map<String, Object> updates) {
        boolean updated = userService.partialUpdateUser(id, updates);
        if (updated) {
            return ResponseEntity.ok("User updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateMembership")
    public ResponseEntity<String> updateMembership(@RequestParam String email) {
        Optional<User> userOptional = userRepo.findByEmail(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setMembership(1); // อัปเดต Membership เป็น 1
            userRepo.save(user);
            return ResponseEntity.ok("Membership updated successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
