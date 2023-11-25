package com.example.webfejlesztes_crud.service;

import com.example.webfejlesztes_crud.model.Pet;

import java.util.List;

public interface PetService {
    List<Pet> getAllPets();
    void savePet(Pet pet);
    Pet getPetById(long id);
    void deletePetById(long id);
}