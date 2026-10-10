package com.example.Ochakovo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MController {

    @GetMapping({"/about", "/about.html"})
    public String about() {
        return "about";
    }

    @GetMapping({"/conditions", "/conditions.html"})
    public String conditions() {
        return "conditions";
    }

    @GetMapping({"/", "/home.html"})
    public String home() {
        return "home";
    }


    @GetMapping({"/jobs", "/jobs.html"})
    public String jobs() {
        return "jobs";
    }

    @GetMapping({"/professions", "/professions.html"})
    public String professions() {
        return "professions";
    }


    @GetMapping({"/try", "/try.html"})
    public String tryPage() {
        return "try";
    }
}
