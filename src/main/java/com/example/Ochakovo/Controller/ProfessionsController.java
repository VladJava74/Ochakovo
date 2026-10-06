package com.example.Ochakovo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfessionsController {

    @GetMapping({"/professions", "/professions.html"})
    public String professions() {
        return "professions";
    }
}