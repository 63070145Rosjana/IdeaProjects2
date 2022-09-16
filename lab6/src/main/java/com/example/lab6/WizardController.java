package com.example.lab6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class WizardController {
    @Autowired
    private WizardService wizardService;

    @RequestMapping(value = "/wizards", method = RequestMethod.GET)
    public List<Wizard> getWizards(){
        List<Wizard> wizards = wizardService.retrieveWizard();

        return wizards;
    }
//    @RequestMapping(value = "/addWizard", method = RequestMethod.GET)
//    public ResponseEntity createWizard(){
//        List<Wizard> wizards = wizardService.retrieveWizard();
//        return ResponseEntity.ok(wizards);
//    }
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
