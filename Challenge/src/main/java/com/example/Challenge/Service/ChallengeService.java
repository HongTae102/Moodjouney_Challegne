package com.example.Challenge.Service;

import java.util.List;
import java.util.Map;
import com.example.Challenge.Dto.ChallengeDTO;
import com.example.Challenge.Entity.Challenge;

public interface ChallengeService {
    String addChallenge(ChallengeDTO challengeDTO);
    void deleteChallenge(int id);
    Challenge getChallengeById(int id);
    boolean updateChallenge(int id, ChallengeDTO challengeDTO);
    boolean partialUpdateChallenge(int id, Map<String, Object> updates);
    List<Challenge> getAllChallenges();
}
