package com.rescueAnimal.API.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rescueAnimal.API.Entities.Association;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Long>{

    List<Association> findAll();

    @Query("From Association a Where a.id = :id")
    Optional<Association> findById(@Param("id") String id);
}
