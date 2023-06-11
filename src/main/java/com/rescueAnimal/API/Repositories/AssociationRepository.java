package com.rescueAnimal.API.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rescueAnimal.API.Entities.Association;

import java.util.List;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Long>{

    List<Association> findAll();

}
