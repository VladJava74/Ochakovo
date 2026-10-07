package com.example.Ochakovo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CareerController {

    @GetMapping({"/career", "/career.html"})
    public String careerPage() {
        return "career";
    }


}
