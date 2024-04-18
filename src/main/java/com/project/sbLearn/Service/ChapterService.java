package com.project.sbLearn.Service;

import com.project.sbLearn.Entity.AccountChapterEntity;
import com.project.sbLearn.Entity.AccountEntity;
import com.project.sbLearn.Entity.ChapterEntity;
import com.project.sbLearn.Repository.AccountChapterRepository;
import com.project.sbLearn.Repository.AccountRepository;
import com.project.sbLearn.Repository.ChapterRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChapterService {
    @Autowired
    ChapterRepository chapterRepository;

    @Autowired
    AccountChapterRepository accountChapterRepository;

    @Autowired
    AccountRepository accountRepository;

    public ChapterEntity getChapterId(int chapterLevel){
        return chapterRepository.findCIdByChapterLevel(chapterLevel);
    }

    public AccountChapterEntity getFirstIncompleteChapter(String uid){
        List<AccountChapterEntity> accountChapterEntities = accountChapterRepository.findByUserId(uid);
        int firstIncompleteId = 0;
        boolean foundIncompleteChapter = false;
        for(AccountChapterEntity accountChapter : accountChapterEntities){
            if(accountChapter.getStatus().equalsIgnoreCase("Incomplete")){
                System.out.println("INI INCOMPLETE PERTAMA : " + accountChapter.getChapterId());
                firstIncompleteId = accountChapter.getChapterLevel();
                return accountChapter;
            }
        }
        return null;
    }

    @Transactional
    public void setChapterStatus(String uid, String cid, String status){
        AccountChapterEntity accountChapterEntity = accountChapterRepository.findByUserIdAndChapterId(uid, cid);
        int highestChapter = accountChapterEntity.getChapterLevel();
        Optional<AccountEntity> accountEntityOptional = accountRepository.findByUid(uid);
        if(accountEntityOptional.isPresent()){
            AccountEntity accountEntity = accountEntityOptional.get();
            accountEntity.setHighestChapter(highestChapter);
            accountRepository.save(accountEntity);
            System.out.println("success update db highest chapter");
        }else{
            System.out.println(" Gagal cuy NOT FOUND : " + highestChapter);
        }
        accountChapterEntity.setStatus(status);
        accountChapterRepository.save(accountChapterEntity);
        System.out.println("scucess update db status account chapter");
    }

}
