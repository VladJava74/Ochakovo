package com.example.Ochakovo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MController {

    @GetMapping({"/about", "/about.html"})
    public String about() {
        return "about";
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

    @GetMapping({"/apply", "/apply.html"})
    public String apply() {
        return "apply";
    }

    @GetMapping({"/games/game01", "/games/game01.html"})
    public String game01() {
        return "games/game01";
    }

    @GetMapping({"/games/game02", "/games/game02.html"})
    public String game02() {
        return "games/game02";
    }

    @GetMapping({"/games/game03", "/games/game03.html"})
    public String game03() {
        return "games/game03";
    }

    @GetMapping({"/games/game04", "/games/game04.html"})
    public String game04() {
        return "games/game04";
    }

    @GetMapping({"/games/game05", "/games/game05.html"})
    public String game05() {
        return "games/game05";
    }

    @GetMapping({"/games/game06", "/games/game06.html"})
    public String game06() {
        return "games/game06";
    }
}
