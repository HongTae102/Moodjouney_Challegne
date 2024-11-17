package com.example.Challenge.Service;

import java.util.List;
import com.example.Challenge.Dto.EncorageDTO;
import com.example.Challenge.Entity.Encorage;

public interface EncorageService {
    String addEncorage(EncorageDTO encorageDTO);
    List<Encorage> getAllEncorage();
    Encorage getEncorageById(Long id);
    String updateEncorage(Long id, EncorageDTO encorageDTO);
    String deleteEncorage(Long id);
}

