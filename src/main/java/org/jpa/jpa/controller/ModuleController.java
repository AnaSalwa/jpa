package org.jpa.jpa.controller;

import org.jpa.jpa.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.jpa.jpa.*;
import org.jpa.jpa.model.Module;
import org.jpa.jpa.model.Module;

import java.util.List;

@RestController
public class ModuleController {

    @Autowired
    private ModuleService moduleService;
    @RequestMapping("/modules")

    public List<Module> getModules() {
        return moduleService.getAllModules();

    }
//    @RequestMapping("/modules/{id}")
//    public Module getModule(@PathVariable Integer id){
//        return moduleService.getModule(id);
//    }

    @RequestMapping(method=RequestMethod.POST, value="/modules/add")
    public void ajouterModule(@RequestBody Module module) {
        moduleService.ajouterModule(module);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/modules/{id}")
    public void modifierModule(@RequestBody Module module, @PathVariable Integer id) {
        moduleService.modifierModule(id, module);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/modules/{id}")
    public void supprimerModule(@PathVariable Integer id) {
        moduleService.supprimerModule(id);
    }
}

