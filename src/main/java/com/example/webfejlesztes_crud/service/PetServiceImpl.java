package com.example.webfejlesztes_crud.service;

import com.example.webfejlesztes_crud.model.Pet;
import com.example.webfejlesztes_crud.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public void savePet(Pet pet) {
        this.petRepository.save(pet);
    }

    @Override
    public Pet getPetById(long id) {
        Optional<Pet> optional = petRepository.findById(id);
        Pet pet = null;
        if (optional.isPresent()) {
            pet = optional.get();
        } else {
            throw new RuntimeException(" Pet not found for id :: " + id);
        }
        return pet;
    }

    @Override
    public void deletePetById(long id) {
        this.petRepository.deleteById(id);
    }
}
