package com.spring.controller;

import com.spring.Enums.Gender;
import com.spring.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MentorController {

    @RequestMapping("/list")
    public String mentor(Model model){
        List<Mentor> mentors = new ArrayList<>();
        mentors.add(new Mentor("Tom", "Smith", 35, Gender.Male));
        mentors.add(new Mentor("Luisa", "Crosse", 32, Gender.Female));
        mentors.add(new Mentor("Vonya", "Womack", 45, Gender.Female));
        mentors.add(new Mentor("Henry", "Holly", 40, Gender.Male));

        model.addAttribute("mentors", mentors);

        return "mentor/mentor";
    }
}
