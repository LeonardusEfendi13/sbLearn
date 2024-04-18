package com.project.sbLearn.Repository;

import com.project.sbLearn.Entity.AccountChapterEntity;
import com.project.sbLearn.Entity.AccountLessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountLessonRepository extends JpaRepository<AccountLessonEntity, String> {
    AccountLessonEntity findByUserIdAndLessonId(String userId, String lessonId);

}
