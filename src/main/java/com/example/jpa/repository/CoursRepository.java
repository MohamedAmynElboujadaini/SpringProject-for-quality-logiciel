package com.example.jpa.repository;

import com.example.jpa.modele.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoursRepository extends CrudRepository<Course, Integer> {
    public List<Course> findByModuleId(Integer moduleId);
}
