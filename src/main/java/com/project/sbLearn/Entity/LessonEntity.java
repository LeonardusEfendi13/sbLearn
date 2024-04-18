package com.project.sbLearn.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lessons")
public class LessonEntity {
    @Id
    @Column(name = "L_ID")
    private String lessonId;

    @Column(name = "QUESTIONS")
    private String questions;

    @Column(name = "QUESTIONS_NUMBER")
    private int questionsNumber;

    @Column(name = "ANSWERS")
    private String answers;

    @Column(name = "GOLD_REWARD")
    private int goldReward;

    @Column(name = "C_ID")
    private String chapterId;

    @Column(name = "EXP_REWARD")
    private int expReward;
}
