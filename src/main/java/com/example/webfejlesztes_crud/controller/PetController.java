package com.example.webfejlesztes_crud.controller;

import com.example.webfejlesztes_crud.model.Owner;
import com.example.webfejlesztes_crud.model.Pet;
import com.example.webfejlesztes_crud.service.OwnerService;
import com.example.webfejlesztes_crud.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private OwnerService ownerService;

    // display list of pets
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listPet", petService.getAllPets());
        return "index";
    }

    @GetMapping("/showNewPetForm")
    public String showNewPetForm(Model model) {
        // create model attribute to bind form data
        Pet pet = new Pet();
        model.addAttribute("pet", pet);
        model.addAttribute("owners", ownerService.getAllOwners());
        return "new_pet";
    }


    @PostMapping("/savePet")
    public String savePet(@ModelAttribute("pet") Pet pet, @RequestParam(value = "ownerId", required = true) Long ownerId) {

        // save pet to database
        if (ownerId != null) {
            // Ha van ownerId, akkor állítsd be a tulajdonost
            Owner owner = ownerService.getOwnerById(ownerId);
            pet.setOwner(owner);
            System.out.println("Received ownerId: " + ownerId);
        } else {
            // Ha nincs ownerId, hozz létre egy Pet-et null tulajdonossal
            pet.setOwner(null);
            System.out.println("Az owner ID null");
        }
        petService.savePet(pet);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") Long id, Model model) {

        // get pet from the service
        Pet pet = petService.getPetById(id);

        // set pet as a model attribute to pre-populate the form
        model.addAttribute("pet", pet);
        model.addAttribute("owners", ownerService.getAllOwners());
        return "update_pet";
    }

    @GetMapping("/deletePet/{id}")
    public String deletePet(@PathVariable (value = "id") Long id) {

        // call delete pet method
        this.petService.deletePetById(id);
        return "redirect:/";
    }

}