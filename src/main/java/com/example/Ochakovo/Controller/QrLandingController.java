package com.example.Ochakovo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QrLandingController {

    @GetMapping({"/qr", "/qr.html"})
    public String qrLanding() {
        return "qr";
    }
}
