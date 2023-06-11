package com.rescueAnimal.API.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rescueAnimal.API.Entities.Animal;
import com.rescueAnimal.API.Repositories.AnimalRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/animal")
public class AnimalController {

    @Autowired
    private static AnimalRepository animalsRepository;
    

    @GetMapping("animals/add")
    public void addAnimals(){

        List<Animal> ANIMALS = List.of(
            //new Animal(1L, "john", "doe", "john@javawhizz.com"),
        );

        animalsRepository.saveAll(ANIMALS);
    }

	
	@GetMapping("animals/all")
	public List<Animal> getAllAnimals() throws Exception {
		return animalsRepository.findAll();
	}

    @GetMapping("animals/association/{id}")
	public List<Animal> getAnimalsFromAssociationId(@PathVariable("id") Long id) throws Exception {
		return animalsRepository.findByAssociationId(id);
	}


	@GetMapping("/animals/{id}")
    public Animal getAnimalFromId(@PathVariable("id") Long id) throws Exception {
        Animal animal = new Animal();
        
        Optional<Animal> a = animalsRepository.findById(id);
        if (a.isPresent()) animal = a.get();

        return animal;
    }
}