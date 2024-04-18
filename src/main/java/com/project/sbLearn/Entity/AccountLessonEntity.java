package com.project.sbLearn.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account_lessons")
@IdClass(AccountLessonId.class)
public class AccountLessonEntity {
    @Id
    @Column(name = "USER_ID", length = 36)
    private String userId;

    @Id
    @Column(name = "LESSON_ID", length = 36)
    private String lessonId;

    @Column(name = "ANSWER_USER", length = 36)
    private String answerUser;

    @Column(name = "status")
    private String status;

    @Column(name = "ANSWERS_DB", length = 50)
    private String answersDb;
}
