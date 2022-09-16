package com.example.lab6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WizardService {
    @Autowired
    private WizardRepository repository;

    public WizardService(WizardRepository repository) {
        this.repository = repository;
    }
    public List<Wizard> retrieveWizard(){
        return repository.findAll();
    }
    public Integer countWizard(){
        long num = repository.count();
        int count = 0;
        for(long i = 0 ;i < num; i++){
            count++;
        }
        System.out.println(count);
        return count;
    }
}
