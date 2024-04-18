package com.project.sbLearn.Service;

import com.project.sbLearn.Entity.AccountEntity;
import com.project.sbLearn.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardService {
    @Autowired
    private AccountRepository accountRepository;

    public List<AccountEntity> inquiryUser(){
        return accountRepository.findAll(Sort.by(Sort.Direction.DESC, "exp"));
    }
}
