package com.example.Challenge.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Challenge.Dto.EncorageDTO;
import com.example.Challenge.Entity.Encorage;
import com.example.Challenge.Repo.EncorageRepo;
import com.example.Challenge.Service.EncorageService;

import java.util.List;
import java.util.Optional;

@Service
public class EncorageServiceImpl implements EncorageService {

    @Autowired
    private EncorageRepo encorageRepo;

    @Override
    public String addEncorage(EncorageDTO encorageDTO) {
        Encorage encorage = new Encorage();
        encorage.setName(encorageDTO.getName());
        encorage.setDescription(encorageDTO.getDescription());
        encorageRepo.save(encorage);
        return "Encorage added successfully";
    }

    @Override
    public List<Encorage> getAllEncorage() {
        return encorageRepo.findAll();
    }

    @Override
    public Encorage getEncorageById(Long id) {
        Optional<Encorage> encorage = encorageRepo.findById(id);
        return encorage.orElse(null);
    }

    @Override
    public String updateEncorage(Long id, EncorageDTO encorageDTO) {
        Optional<Encorage> existingEncorage = encorageRepo.findById(id);
        if (existingEncorage.isPresent()) {
            Encorage encorage = existingEncorage.get();
            encorage.setName(encorageDTO.getName());
            encorage.setDescription(encorageDTO.getDescription());
            encorageRepo.save(encorage);
            return "Encorage updated successfully";
        } else {
            return "Encorage not found";
        }
    }

    @Override
    public String deleteEncorage(Long id) {
        if (encorageRepo.existsById(id)) {
            encorageRepo.deleteById(id);
            return "Encorage deleted successfully";
        } else {
            return "Encorage not found";
        }
    }
}

