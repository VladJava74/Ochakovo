package com.example.Ochakovo.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    // API для сохранения новой анкеты из игры
    @PostMapping("/api/feedback")
    @ResponseBody
    public ResponseEntity<?> createFeedback(@RequestBody Feedback fb) {
        if (fb.getFullName() == null || fb.getFullName().trim().length() < 2) {
            return ResponseEntity.badRequest().body("Укажите ФИО");
        }
        if (fb.getRatingOverall() == null || fb.getRatingOverall() < 1 || fb.getRatingOverall() > 5) {
            return ResponseEntity.badRequest().body("Оцените проект от 1 до 5");
        }
        feedbackRepository.save(fb);
        return ResponseEntity.ok("Спасибо! Анкета отправлена HR.");
    }

    // Страница со списком всех отзывов
    @GetMapping("/admin/feedback")
    public String feedbackPage(Model model) {
        List<Feedback> all = feedbackRepository.findAll();
        model.addAttribute("feedbacks", all);
        model.addAttribute("total", all.size());

        // Подсчет статистики
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

        return "admin/feedback";
    }

    // 🔑 УДАЛЕНИЕ АНКЕТЫ
    @PostMapping("/admin/feedback/{id}/delete")
    public String deleteFeedback(@PathVariable Long id) {
        feedbackRepository.deleteById(id);
        return "redirect:/admin/feedback";
    }

    // 🔑 ОТКРЫТИЕ ФОРМЫ РЕДАКТИРОВАНИЯ
    @GetMapping("/admin/feedback/{id}/edit")
    public String editFeedbackForm(@PathVariable Long id, Model model) {
        Feedback fb = feedbackRepository.findById(id).orElse(null);
        if (fb == null) {
            return "redirect:/admin/feedback";
        }
        model.addAttribute("fb", fb);
        return "admin/feedback-edit";
    }

    // 🔑 СОХРАНЕНИЕ ИЗМЕНЕНИЙ
    @PostMapping("/admin/feedback/{id}/edit")
    public String updateFeedback(@PathVariable Long id, @ModelAttribute Feedback form) {
        Feedback fb = feedbackRepository.findById(id).orElse(null);
        if (fb != null) {
            // Обновляем старые поля
            fb.setName(form.getName());
            fb.setStudentGroup(form.getStudentGroup());
            fb.setRatingGame1(form.getRatingGame1());
            fb.setRatingGame2(form.getRatingGame2());
            fb.setRatingGame3(form.getRatingGame3());
            fb.setRatingOverall(form.getRatingOverall());
            fb.setLikedMost(form.getLikedMost());
            fb.setImprovements(form.getImprovements());
            fb.setWouldRecommend(form.getWouldRecommend());

            // Обновляем новые поля (HR)
            fb.setFullName(form.getFullName());
            fb.setDob(form.getDob());
            fb.setContact(form.getContact());
            fb.setEmail(form.getEmail());
            fb.setUniversity(form.getUniversity());
            fb.setVacancy(form.getVacancy());
            fb.setReadiness(form.getReadiness());

            feedbackRepository.save(fb);
        }
        return "redirect:/admin/feedback";
    }

    // Ручное добавление анкеты (если нужно)
    @PostMapping("/admin/feedback/add")
    public String addFeedback(@ModelAttribute Feedback form) {
        feedbackRepository.save(form);
        return "redirect:/admin/feedback";
    }
}