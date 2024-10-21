package com.example.jpa.controleur;


import java.util.List;
import java.util.Optional;

import com.example.jpa.modele.Course;
import com.example.jpa.modele.CourseModule;
import com.example.jpa.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController //pour indiquer que c’est un controller Rest pour gérer les mappings après
public class CoursController {
    @Autowired //pour faire de l’injection de la classe CoursService au niveau du Controller
    private CoursService coursService;
    @RequestMapping("/modules/{id}/cours") //pour récupérer les cours d’un Module, nous indiquons l’id du
//module en question
    public List<Course> getAllCours(@PathVariable Integer id){
        return coursService.getAllCours(id);
    }
    @RequestMapping("/modules/{moduleId}/cours/{id}")
//pour avoir un cours donné d’un module donné
    public Optional<Course> getCours(@PathVariable Integer id){
        return coursService.getCours(id);
    }
    @RequestMapping(method=RequestMethod.POST, value="/modules/{moduleId}/cours")
//pour ajouter un Cours à un Module donné
    public void ajouterCours(@RequestBody Course cours, @PathVariable Integer moduleId) {
        cours.setModule(new CourseModule(moduleId,"",""));
        coursService.ajouterCours(cours);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/modules/{moduleId}/cours/{id}")
//pour modifier un Cours donné d’un Module donné
    public void modifierCours(@RequestBody Course cours, @PathVariable Integer moduleId,
                              @PathVariable Integer id) {
        cours.setModule(new CourseModule(moduleId,"",""));
        coursService.modifierCours(cours);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/modules/{moduleId}/cours/{id}")
//pour supprimer un Cours donné d’un Module donné
    public void supprimerCours(@PathVariable Integer id) {
        coursService.supprimerCours(id);
    }
}