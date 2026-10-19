package com.example.Ochakovo.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class LeadController {

    @Autowired
    private LeadRepository leadRepository;

    @PostMapping("/leads")
    public ResponseEntity<?> createLead(@RequestBody Lead lead) {
        if (lead.getName() == null || lead.getContact() == null) {
            return ResponseEntity.badRequest().body("Ошибка: пустые поля");
        }
        leadRepository.save(lead);
        return ResponseEntity.ok("Заявка сохранена");
    }
}

@Controller
class AdminController {

    @Autowired
    private LeadRepository leadRepository;

    @GetMapping("/admin/leads")
    public String adminLeads(Model model) {
        model.addAttribute("leads", leadRepository.findAll());
        return "admin/leads";
    }
}