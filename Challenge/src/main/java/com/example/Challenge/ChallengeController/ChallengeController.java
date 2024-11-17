package com.example.Challenge.ChallengeController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Challenge.Dto.ChallengeDTO;
import com.example.Challenge.Entity.Challenge;
import com.example.Challenge.Service.ChallengeService;

@RestController
@RequestMapping("api/challenge")
@CrossOrigin(origins = "http://localhost:3000")
public class ChallengeController {
    @Autowired
    private ChallengeService challengeService;    

    @PostMapping(path = "/save")
    public String saveChallenge(@RequestBody ChallengeDTO challengeDTO) {
        String id = challengeService.addChallenge(challengeDTO);
        return id;
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable int id) {
        challengeService.deleteChallenge(id);
        return ResponseEntity.ok("Challenge deleted successfully");
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Challenge> getChallengeById(@PathVariable int id) {
        Challenge challenge = challengeService.getChallengeById(id);
        if (challenge != null) {
            return ResponseEntity.ok(challenge);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Challenge>> getAllChallenges() {
    List<Challenge> challenges = challengeService.getAllChallenges();
    if (!challenges.isEmpty()) {
        return ResponseEntity.ok(challenges);
    } else {
        return ResponseEntity.noContent().build();
    }
}


    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable int id, @RequestBody ChallengeDTO challengeDTO) {
    boolean updated = challengeService.updateChallenge(id, challengeDTO);
    if (updated) {
        return ResponseEntity.ok("Challenge updated successfully");
    } else {
        return ResponseEntity.notFound().build();
    }
}

    @PatchMapping(path = "/update/{id}")
    public ResponseEntity<String> partialUpdateChallenge(@PathVariable int id, @RequestBody Map<String, Object> updates) {
    boolean updated = challengeService.partialUpdateChallenge(id, updates);
    if (updated) {
        return ResponseEntity.ok("Challenge updated successfully");
    } else {
        return ResponseEntity.notFound().build();
    }
}
}
