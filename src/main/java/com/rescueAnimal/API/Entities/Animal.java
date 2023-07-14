package com.rescueAnimal.API.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "animal")
public class Animal {

	public enum SIZE {
		SMALL,
		MEDIUM,
		BIG
	}
	
	public enum TYPE {
		DOG,
		CAT,
		RABBIT,
		OTHER
	}

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private Integer bornYear;

    @Column
    private TYPE type;

    @Column
    private SIZE size;

    @Column(columnDefinition="TEXT")
    private String description;

    @Column
    private String image;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "association_id", referencedColumnName = "id")
    private Association association;
}
