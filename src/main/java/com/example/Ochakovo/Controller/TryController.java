package com.example.Ochakovo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TryController {

    @GetMapping({"/try", "/try.html"})
    public String tryPage() {
        return "try";
    }
}