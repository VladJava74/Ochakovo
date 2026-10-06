package com.example.Ochakovo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentsController {

    @GetMapping({"/students", "/students.html"})
    public String students() {
        return "students";
    }
}