package com.example.lab6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class WizardController {
    @Autowired
    private WizardService wizardService;

    @RequestMapping(value = "/wizards", method = RequestMethod.GET)
    public List<Wizard> getWizards(){
        List<Wizard> wizards = wizardService.retrieveWizard();

        return wizards;
    }
    @RequestMapping(value = "/addWizard", method = RequestMethod.POST)
    public ResponseEntity<?> createWizard(@RequestBody Wizard wizard){

       Wizard wizards = wizardService.createWizard(wizard);
        return ResponseEntity.ok(wizards);
    }
//    @RequestMapping(value = "/updateWizard", method = RequestMethod.GET)
//    public ResponseEntity updateWizard(){
//        List<Wizard> wizards = wizardService.retrieveWizard();
//        return ResponseEntity.ok(wizards);
//    }
//    @RequestMapping(value = "/deleteWizard", method = RequestMethod.GET)
//    public boolean deleteWizard(){
//        List<Wizard> wizards = wizardService.retrieveWizard();
//        return ResponseEntity.ok(wizards);
//    }
}
