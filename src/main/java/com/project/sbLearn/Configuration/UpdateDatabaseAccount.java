package com.project.sbLearn.Configuration;

import com.project.sbLearn.Entity.AccountEntity;
import com.project.sbLearn.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateDatabaseAccount {

    @Autowired
    private AccountRepository accountRepository;

//    @Scheduled(fixedRate = 10000) //10detik
    @Scheduled(cron = "0 0 0 * * *")
    public void updateLife(){
        List<AccountEntity> accountEntities = accountRepository.findAll();
        for (AccountEntity user : accountEntities){
            if(user.getLife() < 3){
                user.setLife(3);
                System.out.println("SUCCESS UPDATE LIFE : "+user.getName());
            }
            accountRepository.save(user);

        }
        System.out.println("SUCCESS UPDATE ALL LIFE");
    }
}
