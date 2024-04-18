package com.project.sbLearn.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account_chapters")
@IdClass(AccountChapterId.class)
public class AccountChapterEntity {

    @Id
    @Column(name = "USER_ID")
    private String userId;

    @Id
    @Column(name = "CHAPTER_ID")
    private String chapterId;

    @Column(name = "CHAPTER_LEVEL")
    private Integer chapterLevel;

    @Column(name = "status")
    private String status;

}
