package com.project.sbLearn.Service;

import com.project.sbLearn.Entity.AccountEntity;
import com.project.sbLearn.Entity.AccountLessonEntity;
import com.project.sbLearn.Entity.LessonEntity;
import com.project.sbLearn.Repository.AccountLessonRepository;
import com.project.sbLearn.Repository.AccountRepository;
import com.project.sbLearn.Repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
    @Autowired
    LessonRepository lessonsRepository;

    @Autowired
    AccountLessonRepository accountLessonRepository;

    @Autowired
    AccountRepository accountRepository;

    public List<LessonEntity> displayLesson(String cid){
        return lessonsRepository.findByChapterId(cid);
    }

    public void saveLessonToAccountLesson(String uid, String lId, String ansDb, String ansUser, String status){
        AccountLessonEntity accountLessonEntity = new AccountLessonEntity();
        accountLessonEntity.setUserId(uid);
        accountLessonEntity.setLessonId(lId);
        accountLessonEntity.setAnswersDb(ansDb);
        accountLessonEntity.setAnswerUser(ansUser);
        accountLessonEntity.setStatus(status);
        accountLessonRepository.save(accountLessonEntity);
        System.out.println("SUCCESS SAVE TO ACCOUNT LESSON");
    }

    public void updateAccount(String uId, String status, String lId){
        int addGold = 0;
        int addExp = 0;
        Optional<AccountEntity> accountEntityOptional = accountRepository.findByUid(uId);

        if(accountEntityOptional.isPresent()){
            AccountEntity accountEntity = accountEntityOptional.get();
            LessonEntity lessonEntity = lessonsRepository.findByLessonId(lId);
            if("true".equalsIgnoreCase(status)){
                addGold = accountEntity.getGold() + lessonEntity.getGoldReward();
                addExp = accountEntity.getExp() + lessonEntity.getExpReward();
                accountEntity.setGold(addGold);
                accountEntity.setExp(addExp);
            }else {
                int minusLife = accountEntity.getLife() - 1;
                accountEntity.setLife(minusLife);
            }
            accountEntity.setHighestLesson(lessonEntity.getQuestionsNumber());
            accountRepository.save(accountEntity);
        }else {
            System.out.println("not found acc");
            throw new RuntimeException("Account not found with id : " + uId);
        }

    }
}
