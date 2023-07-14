package com.rescueAnimal.API.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.rescueAnimal.API.Entities.Animal;
import com.rescueAnimal.API.Entities.Association;
import com.rescueAnimal.API.Repositories.AnimalRepository;
import com.rescueAnimal.API.Repositories.AssociationRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/animals")
public class AnimalController {

    @Autowired
    private AnimalRepository animalsRepository;

    @Autowired
    private AssociationRepository associationsRepository;
    

    @GetMapping("/add")
    public void addAnimals(){

        List<Association> ASSOCIATIONS = List.of(
            new Association(1L, "RifugiodiAmola", "rifugiodiAmola@gmail.com", "+393474647076"),
            new Association(2L, "IsoladelVagabondo", "isoladelvagabondo@gmail.com", "+391654329625"),
            new Association(3L, "MondoCarota-ConigliInCercaDiCasa", "mondocarota@gmail.com", "+393885740975"),
            new Association(4L, "AssociazioneUnaZampaPerSempreOnlus", "  unazampapersempre@gmail.com", "+393769651541")
        );

        associationsRepository.saveAll(ASSOCIATIONS);

        List<Animal> ANIMALS = List.of(
           new Animal(1L, "Blu", 2022, Animal.TYPE.DOG, Animal.SIZE.SMALL, "Vivace ed energico cucciolone di cane", "ImmaginiAnimali/Blu.jpg", associationsRepository.findById(1L).get()),
           new Animal(2L, "Pina", 2016, Animal.TYPE.CAT, Animal.SIZE.MEDIUM, "Gatta pacata e solitaria",  "ImmaginiAnimali/Pina.jpg", associationsRepository.findById(2L).get()),
           new Animal(3L, "Pepe", 2019, Animal.TYPE.CAT, Animal.SIZE.SMALL, "Gatto che ama giocare con i suoi simili e con i gomitoli di lana",  "ImmaginiAnimali/Pepe.jpg", associationsRepository.findById(2L).get()),
           new Animal(4L, "Casper", 2015, Animal.TYPE.DOG, Animal.SIZE.MEDIUM, "È un cane estremamente sensibile ed intelligente, elegante e dalla linea perfetta", "ImmaginiAnimali/Casper.jpg", associationsRepository.findById(1L).get()),
           new Animal(5L, "Whisky", 2021, Animal.TYPE.RABBIT, Animal.SIZE.SMALL, "È un coniglio timido che ama ricevere tante coccole", "ImmaginiAnimali/Whisky.jpg", associationsRepository.findById(3L).get()),
           new Animal(6L, "Lupo", 2013, Animal.TYPE.DOG, Animal.SIZE.MEDIUM, "Lupo, detto Lupino, è un cane selvaggio ed affascinante", "ImmaginiAnimali/Lupo.jpg", associationsRepository.findById(1L).get()),
           new Animal(7L, "Nica", 2023, Animal.TYPE.CAT, Animal.SIZE.SMALL, "Gatta molto pigra che ama passare tanto tempo sulla poltrona",  "ImmaginiAnimali/Nica.jpg",associationsRepository.findById(2L).get()),
           new Animal(8L, "Loky", 2023, Animal.TYPE.CAT, Animal.SIZE.SMALL, "Gatto giovanissimo e molto curioso di conoscere l'ambiente esterno",  "ImmaginiAnimali/Loky.jpg",associationsRepository.findById(2L).get()),
           new Animal(9L, "Yoshi", 2017, Animal.TYPE.DOG, Animal.SIZE.BIG, "È canE con un carattere forte, perciò non è indicato per chi con i cani è alla prima esperienza", "ImmaginiAnimali/Yoshi.jpg", associationsRepository.findById(1L).get()),
           new Animal(10L, "Gioia", 2022, Animal.TYPE.RABBIT, Animal.SIZE.SMALL, "È una coniglietta molto buffa", "ImmaginiAnimali/Gioia.jpg",associationsRepository.findById(3L).get()),
           new Animal(11L, "Silver", 2022, Animal.TYPE.DOG, Animal.SIZE.BIG, "Pacato e riflessivo", "ImmaginiAnimali/Silver.jpg", associationsRepository.findById(1L).get()),
           new Animal(12L, "Packy", 2019, Animal.TYPE.OTHER, Animal.SIZE.MEDIUM, "Pappagallo molto rumoroso e impertinente",  "ImmaginiAnimali/Packy.jpg",associationsRepository.findById(4L).get()),
           new Animal(13L, "Macchietta", 2023, Animal.TYPE.OTHER, Animal.SIZE.SMALL, "Maialino molto carino, ma impaurito dagli altri animali",  "ImmaginiAnimali/Macchietta.jpg",associationsRepository.findById(4L).get()),
           new Animal(14L, "Chicco", 2023, Animal.TYPE.OTHER, Animal.SIZE.SMALL, "Tartaruga dolcissima e molto timida",  "ImmaginiAnimali/Chicco.jpg",associationsRepository.findById(4L).get()),
           new Animal(15L, "Fred", 2018, Animal.TYPE.OTHER, Animal.SIZE.SMALL, "È un furetto molto curioso ed estroverso",  "ImmaginiAnimali/Fred.jpg",associationsRepository.findById(4L).get()),
           new Animal(16L, "Xena", 2014, Animal.TYPE.DOG, Animal.SIZE.MEDIUM, "È molto vitale ed energica, una compagna perfetta per escursioni nel verde", "ImmaginiAnimali/Xena.jpg", associationsRepository.findById(1L).get()),
           new Animal(17L, "Alice", 2020, Animal.TYPE.CAT, Animal.SIZE.MEDIUM, "Gatta pantofolaia e una gran golosona",  "ImmaginiAnimali/Alice.jpg",associationsRepository.findById(2L).get()),
           new Animal(18L, "Bandito", 2007, Animal.TYPE.DOG, Animal.SIZE.MEDIUM, "È sempre in cerca di attenzioni e vuole partecipare a qualsiasi attività", "ImmaginiAnimali/Bandito.jpg",associationsRepository.findById(2L).get()),
           new Animal(19L, "Mora", 2011, Animal.TYPE.DOG, Animal.SIZE.MEDIUM, "È uno spirito libero", "ImmaginiAnimali/Mora.jpg", associationsRepository.findById(1L).get()),
           new Animal(20L, "Walter", 2020, Animal.TYPE.OTHER, Animal.SIZE.MEDIUM, "Iguana pacato e riflessivo",  "ImmaginiAnimali/Walter.jpg",associationsRepository.findById(4L).get())

        );

        animalsRepository.saveAll(ANIMALS);
    }

	
	@GetMapping("/all")
	public List<Animal> getAllAnimals() throws Exception {
		return animalsRepository.findAll();
	}

    @GetMapping("/association/{id}")
	public List<Animal> getAnimalsFromAssociationId(@PathVariable("id") Long id) throws Exception {
		return animalsRepository.findByAssociationId(id);
	}


	@GetMapping("/{id}")
    public Animal getAnimalFromId(@PathVariable("id") Long id) throws Exception {
        Animal animal = new Animal();
        
        Optional<Animal> a = animalsRepository.findById(id);
        if (a.isPresent()) animal = a.get();

        return animal;
    }

    @RequestMapping(value = "{id}/getImage", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<InputStreamResource> getImage(@PathVariable("id") Long id) throws Exception {
        Animal a = getAnimalFromId(id);
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(new ClassPathResource(a.getImage()).getInputStream()));
    }

}