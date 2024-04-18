package com.project.sbLearn.Repository;

import com.project.sbLearn.Entity.ChapterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapterRepository extends JpaRepository<ChapterEntity, String> {
    List<ChapterEntity> findByChapterLevel(Integer chapterLevel);

    ChapterEntity findCIdByChapterLevel(int chapterLevel);

}
