package com.example.jpa.repository;

import com.example.jpa.modele.CourseModule;
import org.springframework.data.repository.CrudRepository;

public interface ModuleRepository extends CrudRepository<CourseModule, Integer> {

}
