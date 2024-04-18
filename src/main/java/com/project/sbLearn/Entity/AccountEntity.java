package com.project.sbLearn.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class AccountEntity {
    @Id
    @Column(name = "U_ID", length = 36)
    private String uid;

    @Column(name = "USERNAME", length = 40)
    private String username;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "PASSWORD", length = 100)
    private String password;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "EXPERIENCE_POINT")
    private int exp;

    @Column(name = "GOLD")
    private int gold;

    @Column(name = "LIFE")
    private int life;

    @Column(name = "BADGE", length = 15)
    private String badge;

    @Column(name = "profile_image")
    private String profilePictureName;

    @Column(name = "HIGHEST_CHAPTER")
    private Integer highestChapter;

    @Column(name = "HIGHEST_LESSON")
    private Integer highestLesson;

    @Column(name = "CURRENT_CHAPTER")
    private Integer currentChapter;
}
