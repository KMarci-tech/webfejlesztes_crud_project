package com.example.webfejlesztes_crud.service;

import com.example.webfejlesztes_crud.model.Owner;

import java.util.List;

public interface OwnerService {

    List<Owner> getAllOwners();
    void saveOwner(Owner owner);
    Owner getOwnerById(long id);
    void deleteOwnerById(long id);
}
