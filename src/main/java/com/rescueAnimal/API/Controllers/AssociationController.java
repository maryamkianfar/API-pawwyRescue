package com.rescueAnimal.API.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rescueAnimal.API.Entities.Association;
import com.rescueAnimal.API.Repositories.AssociationRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/association")
public class AssociationController {

    @Autowired
    private static AssociationRepository associationRepository;

	
	@GetMapping("associations/all")
	public List<Association> getAllAssociations() throws Exception {
		return associationRepository.findAll();
	}


	@GetMapping("/associations/{id}")
    public Association getAssociationFromId(@PathVariable("id") Long id) {
        Association association = new Association();
        
        Optional<Association> a = associationRepository.findById(id);
        if (a.isPresent()) association = a.get();

        return association;
    }
}