package com.rescueAnimal.API.Repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rescueAnimal.API.Entities.Animal;
import com.rescueAnimal.API.Entities.Association;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{

    List<Animal> findAll();

    @Query("From Association l where l.id = :id")
    Association findAssociation(@Param("id") long id);

    @Query("From Animal l where l.association.id = :id")
    List<Animal> findByAssociationId(@Param("id") long id);
}
