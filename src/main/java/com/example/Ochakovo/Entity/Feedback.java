package com.example.Ochakovo.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "feedbacks")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Старые поля (для совместимости)
    private String name;
    private String studentGroup;

    // 🔑 НОВЫЕ ПОЛЯ ДЛЯ HR
    private String fullName;
    private String dob;
    private String contact;
    private String email;
    private String university;
    private String vacancy;
    private String readiness;

    private Integer ratingGame1;
    private Integer ratingGame2;
    private Integer ratingGame3;
    private Integer ratingOverall;
    private String likedMost;
    private String improvements;
    private Boolean wouldRecommend;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() { this.createdAt = LocalDateTime.now(); }

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStudentGroup() { return studentGroup; }
    public void setStudentGroup(String studentGroup) { this.studentGroup = studentGroup; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUniversity() { return university; }
    public void setUniversity(String university) { this.university = university; }

    public String getVacancy() { return vacancy; }
    public void setVacancy(String vacancy) { this.vacancy = vacancy; }

    public String getReadiness() { return readiness; }
    public void setReadiness(String readiness) { this.readiness = readiness; }

    public Integer getRatingGame1() { return ratingGame1; }
    public void setRatingGame1(Integer ratingGame1) { this.ratingGame1 = ratingGame1; }
    public Integer getRatingGame2() { return ratingGame2; }
    public void setRatingGame2(Integer ratingGame2) { this.ratingGame2 = ratingGame2; }
    public Integer getRatingGame3() { return ratingGame3; }
    public void setRatingGame3(Integer ratingGame3) { this.ratingGame3 = ratingGame3; }
    public Integer getRatingOverall() { return ratingOverall; }
    public void setRatingOverall(Integer ratingOverall) { this.ratingOverall = ratingOverall; }
    public String getLikedMost() { return likedMost; }
    public void setLikedMost(String likedMost) { this.likedMost = likedMost; }
    public String getImprovements() { return improvements; }
    public void setImprovements(String improvements) { this.improvements = improvements; }
    public Boolean getWouldRecommend() { return wouldRecommend; }
    public void setWouldRecommend(Boolean wouldRecommend) { this.wouldRecommend = wouldRecommend; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}