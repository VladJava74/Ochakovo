package com.example.Ochakovo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MController {

    @GetMapping({"/about", "/about.html"})
    public String about() {
        return "about";
    }

    @GetMapping({"/career", "/career.html"})
    public String careerPage() {
        return "career";
    }

    @GetMapping({"/conditions", "/conditions.html"})
    public String conditions() {
        return "conditions";
    }

    @GetMapping({"/", "/index.html"})
    public String home() {
        return "index";
    }

    @GetMapping({"/jobs", "/jobs.html"})
    public String jobs() {
        return "jobs";
    }

    @GetMapping({"/professions", "/professions.html"})
    public String professions() {
        return "professions";
    }

    @GetMapping({"/qr", "/qr.html"})
    public String qrLanding() {
        return "qr";
    }

    @GetMapping({"/route", "/route.html"})
    public String route() {
        return "route";
    }

    @GetMapping({"/students", "/students.html"})
    public String students() {
        return "students";
    }

    @GetMapping({"/team", "/team.html"})
    public String team() {
        return "team";
    }

    @GetMapping({"/try", "/try.html"})
    public String tryPage() {
        return "try";
    }
}
