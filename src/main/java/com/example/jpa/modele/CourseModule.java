package com.example.jpa.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class CourseModule {
    @Id
    private int id;
    private String nom;
    private String description;
}
