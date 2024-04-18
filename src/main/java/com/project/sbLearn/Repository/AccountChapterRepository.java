package com.project.sbLearn.Repository;

import com.project.sbLearn.Entity.AccountChapterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountChapterRepository extends JpaRepository<AccountChapterEntity, String> {
    List<AccountChapterEntity> findByUserId(String userId);

    AccountChapterEntity findByUserIdAndChapterId(String userId, String chapterId);

}
