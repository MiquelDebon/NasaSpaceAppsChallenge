package com.galacticspacecoders.hackathon.model.services;

import com.galacticspacecoders.hackathon.model.dto.PhytoplanktonDto;
import com.galacticspacecoders.hackathon.model.entity.Phytoplankton;
import com.galacticspacecoders.hackathon.model.exception.customExceptions.PhytoplanktonNotFoundException;
import com.galacticspacecoders.hackathon.model.repository.PhytoplanktonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PhytoplanktonService {

    @Autowired
    private PhytoplanktonRepository phytoplanktonRepo;

    public PhytoplanktonDto photosynthesis(int id, boolean answer) {

        Optional<Phytoplankton> phytoplankton = phytoplanktonRepo.findById(id);
        if(phytoplankton.isPresent()) {
            //modelMapper
            if (answer) {
                energy += 10;
                salud += 5;
                registerAction();
                return phytoDto;
            } else {
                // El fitoplancton no pudo realizar la fotosíntesis correctamente
                // Reduce su salud
                salud -= 10;
                //registrarAccion();
                return false;
            }
        } else {
            throw new PhytoplanktonNotFoundException();
        }

    }

    private void registerAction(Phytoplankton phytoplankton) {

        phytoplankton.setLastAction(LocalDateTime.now());
    }
}