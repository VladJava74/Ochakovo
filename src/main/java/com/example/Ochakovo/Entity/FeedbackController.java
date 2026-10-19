package com.example.Ochakovo.Entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import java.util.List;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    // API для сохранения отзыва
    @PostMapping("/api/feedback")
    @ResponseBody
    public ResponseEntity<?> createFeedback(@RequestBody Feedback fb) {
        if (fb.getName() == null || fb.getName().trim().length() < 2) {
            return ResponseEntity.badRequest().body("Укажите имя");
        }
        if (fb.getRatingOverall() == null || fb.getRatingOverall() < 1 || fb.getRatingOverall() > 5) {
            return ResponseEntity.badRequest().body("Оцените проект от 1 до 5");
        }
        feedbackRepository.save(fb);
        return ResponseEntity.ok("Спасибо за отзыв!");
    }

    // Страница со всеми отзывами
    @GetMapping("/admin/feedback")
    public String feedbackPage(Model model) {
        List<Feedback> all = feedbackRepository.findAll();
        model.addAttribute("feedbacks", all);
        model.addAttribute("total", all.size());

        if (!all.isEmpty()) {
            double avgOverall = all.stream().filter(f -> f.getRatingOverall() != null)
                    .mapToInt(Feedback::getRatingOverall).average().orElse(0);
            double avg1 = all.stream().filter(f -> f.getRatingGame1() != null)
                    .mapToInt(Feedback::getRatingGame1).average().orElse(0);
            double avg2 = all.stream().filter(f -> f.getRatingGame2() != null)
                    .mapToInt(Feedback::getRatingGame2).average().orElse(0);
            double avg3 = all.stream().filter(f -> f.getRatingGame3() != null)
                    .mapToInt(Feedback::getRatingGame3).average().orElse(0);

            long recommendCount = all.stream()
                    .filter(f -> Boolean.TRUE.equals(f.getWouldRecommend())).count();

            model.addAttribute("avgOverall", Math.round(avgOverall * 10.0) / 10.0);
            model.addAttribute("avg1", Math.round(avg1 * 10.0) / 10.0);
            model.addAttribute("avg2", Math.round(avg2 * 10.0) / 10.0);
            model.addAttribute("avg3", Math.round(avg3 * 10.0) / 10.0);
            model.addAttribute("recommendPercent", Math.round((double) recommendCount / all.size() * 100));
        } else {
            model.addAttribute("avgOverall", 0);
            model.addAttribute("avg1", 0);
            model.addAttribute("avg2", 0);
            model.addAttribute("avg3", 0);
            model.addAttribute("recommendPercent", 0);
        }

        return "admin/feedback"; // ищет файл templates/admin/feedback.html
    }
}