package com.project.sbLearn.Service;

import com.project.sbLearn.Entity.AccountEntity;
import com.project.sbLearn.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean loginCheck(String username, String password) {
        AccountEntity accountEntity = accountRepository.findByUsername(username);
        if(accountEntity != null){
            String passDb = accountEntity.getPassword();
            boolean validatepass = passwordEncoder.matches(password, passDb);
            System.out.println("Raw pass Login : " + password);
            System.out.println("VALUE OF VALIDATE PASS : " + validatepass);
            return validatepass;
        }else{
            return false;
        }

    }
    public AccountEntity getNameFromLogin(String username){
        return accountRepository.findNameByUsername(username);
    }
}

