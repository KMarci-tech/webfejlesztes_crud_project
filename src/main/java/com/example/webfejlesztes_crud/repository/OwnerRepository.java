package com.example.webfejlesztes_crud.repository;

import com.example.webfejlesztes_crud.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
