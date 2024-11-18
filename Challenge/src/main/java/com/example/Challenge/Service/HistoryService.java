package com.example.Challenge.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;
import com.example.Challenge.Entity.History;

public interface HistoryService {
    History addHistory(String description, MultipartFile imageFile, String email) throws IOException;
    List<History> getAllHistory();
    Optional<History> getHistoryById(Long id); 
    List<History> getAllHistories();
}
