package org.jpa.jpa.service;

import org.jpa.jpa.model.Module;
import org.jpa.jpa.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ModuleService {
    @Autowired
    private ModuleRepository moduleRepository;

    public List<Module> getAllModules() {
        List<Module> modules = new ArrayList<>();
        moduleRepository.findAll().forEach(modules::add);
        return modules;
    }

    public void ajouterModule(Module module) {
        moduleRepository.save(module);
    }

    public Optional<Module> getModule(int id) {
        return moduleRepository.findById(id);
    }

    public void supprimerModule(int id) {
        moduleRepository.deleteById(id);
    }

//    public void modifierModule(int id , Module module){
//        moduleRepository.save(module);
//    }

    public void modifierModule(int id, Module module) {
        if (moduleRepository.existsById(id)) {
            module.setId(id);
            moduleRepository.save(module); // Met à jour le module existant
        } else {
            throw new RuntimeException("Module avec ID " + id + " n'existe pas");
        }
    }

}
