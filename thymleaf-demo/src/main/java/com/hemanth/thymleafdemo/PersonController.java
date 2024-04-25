package com.hemanth.thymleafdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class PersonController {
@GetMapping
    public String getPeople(Model model){
    model.addAttribute("something","this is something");
    model.addAttribute("people", Arrays.asList(
            new Person("hemanth","23"),
            new Person("kiran","32"),
           new Person("David", "50"),
            new Person("Emma", "22"),
            new Person("Frank", "33"),
            new Person("Grace", "29"),
            new Person("Henry", "42"),
            new Person("Ivy", "31"),
            new Person("Jack", "26"),
            new Person("Alice", "28"),
            new Person("Bob", "45"),
            new Person("Charlie", "36")
    ));
        return "people";
    }
}
