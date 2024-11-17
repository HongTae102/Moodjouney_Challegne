package com.example.Challenge.ChallengeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Challenge.Dto.EncorageDTO;
import com.example.Challenge.Entity.Encorage;
import com.example.Challenge.Service.EncorageService;

import java.util.List;

@RestController
@RequestMapping("/api/encorage")
@CrossOrigin(origins = "http://localhost:3000")
public class EncorageController {
    

    @Autowired
    private EncorageService encorageService;

    @PostMapping("/add")
    public ResponseEntity<String> addEncorage(@RequestBody EncorageDTO encorageDTO) {
        String response = encorageService.addEncorage(encorageDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Encorage>> getAllEncorage() {
    List<Encorage> encorage = encorageService.getAllEncorage();
    if (!encorage.isEmpty()) {
        return ResponseEntity.ok(encorage);
    } else {
        return ResponseEntity.noContent().build();
    }
}

    @GetMapping("/{id}")
    public ResponseEntity<Encorage> getEncorageById(@PathVariable Long id) {
        Encorage encorage = encorageService.getEncorageById(id);
        if (encorage != null) {
            return ResponseEntity.ok(encorage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEncorage(@PathVariable Long id, @RequestBody EncorageDTO encorageDTO) {
        String response = encorageService.updateEncorage(id, encorageDTO);
        if (response.equals("Encorage updated successfully")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEncorage(@PathVariable Long id) {
        String response = encorageService.deleteEncorage(id);
        if (response.equals("Encorage deleted successfully")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
