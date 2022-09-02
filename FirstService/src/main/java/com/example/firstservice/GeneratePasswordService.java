package com.example.firstservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.ThreadLocalRandom;


@RestController
public class GeneratePasswordService {
    @RequestMapping(value = "{name}.generate", method = RequestMethod.GET)

    public String myAdd(@PathVariable("name") String name){
        int int_random = ThreadLocalRandom.current().nextInt();


        return  "Hi, "+ name + "\nYour new password is " + Math.abs(int_random) + " .";
    }
}
