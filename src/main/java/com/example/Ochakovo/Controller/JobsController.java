package com.example.Ochakovo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobsController {

    @GetMapping({"/jobs", "/jobs.html"})
    public String jobs() {
        return "jobs";
    }
}