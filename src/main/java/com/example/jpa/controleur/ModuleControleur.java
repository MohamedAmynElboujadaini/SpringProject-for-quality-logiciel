package com.example.jpa.controleur;

import com.example.jpa.modele.CourseModule;
import com.example.jpa.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ModuleControleur {

    @Autowired
    private ModuleService moduleService;

    @RequestMapping("/modules")
    public List<CourseModule> getModules() {
        return moduleService.getAllModules();
    }

    @RequestMapping("/modules/{id}")
    public Optional<CourseModule> getModule(@PathVariable Integer id){
        return moduleService.getModule(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/modules")
    public void ajouterModule(@RequestBody CourseModule module) {
        moduleService.ajouterModule(module);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/modules/{id}")
    public void modifierModule(@RequestBody CourseModule module, @PathVariable Integer id) {
        moduleService.modifierModule(id, module);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/modules/{id}")
    public void supprimerModule(@PathVariable Integer id) {
        moduleService.supprimerModule(id);
    }
}