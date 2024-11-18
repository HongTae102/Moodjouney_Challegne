package com.example.Challenge.Service.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.Challenge.Entity.History;
import com.example.Challenge.Repo.HistoryRepo;
import com.example.Challenge.Service.HistoryService;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryRepo historyRepository;

    @Override
    public History addHistory(String description, MultipartFile imageFile, String email) throws IOException {
        History history = new History();
        history.setDescription(description);
        history.setImage(imageFile.getBytes());
        history.setEmail(email);
        history.setCreatedDate(LocalDateTime.now());
        return historyRepository.save(history);
    }

    @Override
    public List<History> getAllHistory() {
        return historyRepository.findAll();
    }

    @Override
    public Optional<History> getHistoryById(Long id) {
        return historyRepository.findById(id);
    }

    @Override
    public List<History> getAllHistories() {
        return historyRepository.findAll();
    }
}
