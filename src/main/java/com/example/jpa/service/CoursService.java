package com.example.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.jpa.modele.Course;
import com.example.jpa.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CoursService {
    @Autowired //pour l’injection des dépendances et éviter l’appel des new()
    private CoursRepository coursRepository;
    public List<Course> getAllCours(Integer moduleId) {
        List<Course> cours=new ArrayList<>();
        coursRepository.findByModuleId(moduleId).forEach(cours::add);
        return cours;
    }
    public Optional<Course> getCours(Integer id) {
        return coursRepository.findById(id);
    }
    public void ajouterCours(Course cours) {
        coursRepository.save(cours); //la méthode save est implémentée dans CourseRepository
    }
    public void modifierCours(Course cours) {
        coursRepository.save(cours); //ici save dans le rôle de la mise à jour
    }
    public void supprimerCours(Integer id) {
        coursRepository.deleteById(id);
    }
}