package com.example.webfejlesztes_crud.service;

import com.example.webfejlesztes_crud.model.Owner;
import com.example.webfejlesztes_crud.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService{

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public void saveOwner(Owner owner) {
        this.ownerRepository.save(owner);
    }

    @Override
    public Owner getOwnerById(long id) {
        Optional<Owner> optional = ownerRepository.findById(id);
        Owner owner = null;
        if (optional.isPresent()) {
            owner = optional.get();
        } else {
            throw new RuntimeException(" Owner not found for id :: " + id);
        }
        return owner;
    }

    @Override
    public void deleteOwnerById(long id) {
        this.ownerRepository.deleteById(id);
    }
}
