package com.project.sbLearn.Repository;

import com.project.sbLearn.Entity.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<LessonEntity, String> {
    List<LessonEntity> findByChapterId(String cid);

    LessonEntity findByLessonId(String lId);
}
