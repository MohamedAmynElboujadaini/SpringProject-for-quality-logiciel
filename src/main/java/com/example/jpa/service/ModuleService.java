package com.example.jpa.service;

import com.example.jpa.modele.CourseModule;
import com.example.jpa.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ModuleService {
    @Autowired
    private ModuleRepository moduleRepository;

    public List<CourseModule> getAllModules() {
        List<CourseModule> modules = new ArrayList<>();
        moduleRepository.findAll().forEach(modules::add);
        return modules;
    }

    public void ajouterModule(CourseModule module) {
        moduleRepository.save(module);
    }

    public Optional<CourseModule> getModule(Integer id) {
        return moduleRepository.findById(id);
    }

    public void modifierModule(Integer id, CourseModule module) {
        moduleRepository.save(module);
    }

    public void supprimerModule(Integer id) {
        moduleRepository.deleteById(id);
    }
}

