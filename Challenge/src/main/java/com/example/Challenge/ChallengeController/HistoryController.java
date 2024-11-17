package com.example.Challenge.ChallengeController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.Challenge.Entity.History;
import com.example.Challenge.Service.HistoryService;

@RestController
@RequestMapping("/api/history")
@CrossOrigin(origins = "http://localhost:3000")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @PostMapping("/add")
    public ResponseEntity<History> addHistory(
            @RequestParam("description") String description,
            @RequestParam("image") MultipartFile imageFile) {
        try {
            History history = historyService.addHistory(description, imageFile);
            return ResponseEntity.ok(history);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/submitted")
    public ResponseEntity<List<History>> getSubmittedChallenges() {
    List<History> historyList = historyService.getAllHistory();
    return ResponseEntity.ok(historyList);
}

@GetMapping("/all")
public ResponseEntity<List<History>> getAllHistory() {
    List<History> histories = historyService.getAllHistory();
    return ResponseEntity.ok(histories);
}

@GetMapping("/{id}")
public ResponseEntity<History> getHistoryById(@PathVariable Long id) {
    Optional<History> history = historyService.getHistoryById(id);
    return history.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
}
}
