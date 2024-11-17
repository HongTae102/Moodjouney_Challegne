package com.example.Challenge.Service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Challenge.Dto.ChallengeDTO;
import com.example.Challenge.Entity.Challenge;
import com.example.Challenge.Repo.ChallengeRepo;
import com.example.Challenge.Service.ChallengeService;

@Service
public class ChallengeServiceImpl implements ChallengeService {

    @Autowired
    private ChallengeRepo challengeRepository;

    @Override
    public String addChallenge(ChallengeDTO challengeDTO) {
        Challenge challenge = new Challenge();
        challenge.setChallenge(challengeDTO.getChallenge());
        challengeRepository.save(challenge);
        return "Challenge saved with ID: " + challenge.getChallenge_id();
    }    

    @Override
    public void deleteChallenge(int id) {
        challengeRepository.deleteById(id);
    }

    @Override
    public Challenge getChallengeById(int id) {
        Optional<Challenge> challenge = challengeRepository.findById(id);
        return challenge.orElse(null);
    }

    @Override
    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }

    @Override
    public boolean updateChallenge(int id, ChallengeDTO challengeDTO) {
        Optional<Challenge> existingChallenge = challengeRepository.findById(id);
        if (existingChallenge.isPresent()) {
            Challenge challenge = existingChallenge.get();
            challenge.setChallenge(challengeDTO.getChallenge());
            challengeRepository.save(challenge);
            return true;
        }
        return false;
    }

    @Override
    public boolean partialUpdateChallenge(int id, Map<String, Object> updates) {
        Optional<Challenge> existingChallenge = challengeRepository.findById(id);
        if (existingChallenge.isPresent()) {
            Challenge challenge = existingChallenge.get();
            if (updates.containsKey("challenge")) {
                challenge.setChallenge((String) updates.get("challenge"));
            }
            challengeRepository.save(challenge);
            return true;
        }
        return false;
    }
}
