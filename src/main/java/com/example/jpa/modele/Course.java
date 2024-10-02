package com.example.jpa.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Course {
    @Id
    private int id;
    private String name;
    private String description;

    @ManyToOne
    private CourseModule module;

    // Constructor without 'id', as 'id' is often generated
    public Course(String name, String description, int moduleId) {
        this.name = name;
        this.description = description;
        this.module = new CourseModule(moduleId, "", "");  // Assuming CourseModule constructor
    }
}
