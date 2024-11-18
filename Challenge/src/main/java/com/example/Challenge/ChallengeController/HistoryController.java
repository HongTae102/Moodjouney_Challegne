package com.example.Challenge.ChallengeController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.Challenge.Entity.History;
import com.example.Challenge.Repo.HistoryRepo;
import com.example.Challenge.Service.HistoryService;

@RestController
@RequestMapping("/api/history")
@CrossOrigin(origins = "http://localhost:3000")
public class HistoryController {

    @Autowired
    private HistoryService historyService;
    @Autowired
    private HistoryRepo historyRepository;

    @PostMapping("/add")
    public ResponseEntity<History> addHistory(
            @RequestParam("description") String description,
            @RequestParam("image") MultipartFile imageFile,
            @RequestParam("email") String email) { // ตรวจสอบว่ารับ email หรือไม่
        try {
            if (description == null || email == null || imageFile.isEmpty()) {
                return ResponseEntity.badRequest().body(null); // ส่ง 400 หากข้อมูลไม่ครบ
            }

            // สร้าง History
            History history = historyService.addHistory(description, imageFile, email);
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

    @GetMapping
    public ResponseEntity<List<History>> getHistoryByEmail(@RequestParam String email) {
        if (email == null || email.isEmpty()) {
            return ResponseEntity.badRequest().build(); 
        }

        // ดึงข้อมูลจากฐานข้อมูลโดยใช้ email
        List<History> historyList = historyRepository.findByEmail(email);
        if (historyList.isEmpty()) {
            return ResponseEntity.noContent().build(); 
        }

        return ResponseEntity.ok(historyList); 
    }
}
