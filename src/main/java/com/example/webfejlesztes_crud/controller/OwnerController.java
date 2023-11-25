package com.example.webfejlesztes_crud.controller;

import com.example.webfejlesztes_crud.model.Owner;
import com.example.webfejlesztes_crud.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/viewOwnerPage")
    public String viewOwnerPage(Model model) {
        model.addAttribute("listOwner", ownerService.getAllOwners());
        return "owner_list";
    }

    @GetMapping("/showNewOwnerForm")
    public String showNewOwnerForm(Model model) {
        // create model attribute to bind form data
        Owner owner = new Owner();
        model.addAttribute("owner", owner);
        return "new_owner";
    }

    @PostMapping("/saveOwner")
    public String saveOwner(@ModelAttribute("owner") Owner owner) {
        // save pet to database
        ownerService.saveOwner(owner);
        return "redirect:viewOwnerPage";
    }

    @GetMapping("/showFormForOwnerUpdate/{id}")
    public String showFormForOwnerUpdate(@PathVariable( value = "id") Long id, Model model) {

        // get pet from the service
        Owner owner = ownerService.getOwnerById(id);

        // set pet as a model attribute to pre-populate the form
        model.addAttribute("owner", owner);
        return "update_owner";
    }

    @GetMapping("/deleteOwner/{id}")
    public String deleteOwner(@PathVariable (value = "id") Long id) {

        // call delete owner method
        this.ownerService.deleteOwnerById(id);
        return "redirect:/viewOwnerPage";
    }

}
