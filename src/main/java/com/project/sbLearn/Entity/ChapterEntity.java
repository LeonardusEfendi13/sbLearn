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
@Table(name = "chapter")
public class ChapterEntity {
    @Id
    @Column(name = "C_ID", length = 36)
    private String cId;

    @Column(name = "CHAPTER_LEVEL", length = 11)
    private int chapterLevel;

    @Column(name = "TITLE", length = 100)
    private String chapterTitle;

}
