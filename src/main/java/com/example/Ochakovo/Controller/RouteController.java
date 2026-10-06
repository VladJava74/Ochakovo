package com.example.Ochakovo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {

    @GetMapping({"/route", "/route.html"})
    public String route() {
        return "route";
    }
}