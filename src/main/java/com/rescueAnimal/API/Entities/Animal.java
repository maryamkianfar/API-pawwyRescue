package com.rescueAnimal.API.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

enum SIZE {
    SMALL,
    MEDIUM,
    BIG
}

enum TYPE {
    DOG,
    CAT,
    RABBIT,
    OTHER
}

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "animal")
public class Animal {

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
