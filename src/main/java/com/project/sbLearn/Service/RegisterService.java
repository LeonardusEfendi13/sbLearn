package com.project.sbLearn.Service;

import com.project.sbLearn.Configuration.EncryptPassword;
import com.project.sbLearn.Entity.AccountChapterEntity;
import com.project.sbLearn.Entity.AccountEntity;
import com.project.sbLearn.Repository.AccountChapterRepository;
import com.project.sbLearn.Repository.AccountRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class RegisterService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountChapterRepository accountChapterRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean isDuplicateUsername(String username){
        return accountRepository.existsByUsername(username);
    }
    public boolean isDuplicateEmail(String email){
        return accountRepository.existsByEmail(email);
    }
    public void registerUser(String name, String username, String email, String password){
        String hashedPass = passwordEncoder.encode(password);
        System.out.println("hashed pass : " + hashedPass);
        System.out.println("Raw pass : " + password);
        UUID uuid = UUID.randomUUID();
        AccountEntity accountEntity = new AccountEntity();
        System.out.println("uuid : " + uuid);
        System.out.println("asu : " + name + username + email + password);
        accountEntity.setUid(uuid.toString());
        accountEntity.setName(name);
        accountEntity.setUsername(username);
        accountEntity.setEmail(email);
        accountEntity.setPassword(hashedPass);
        accountEntity.setExp(0);
        accountEntity.setGold(50);
        accountEntity.setLife(3);
        accountEntity.setBadge("Bronze");
        accountEntity.setProfilePictureName("avatar10");
        accountRepository.save(accountEntity);


        List<String> cIds = fetchCid();
        List<AccountChapterEntity> accountChapterEntities = new ArrayList<>();
        int x = 1;
        for (String cid : cIds){
            AccountChapterEntity accountChapterEntity = new AccountChapterEntity();
            accountChapterEntity.setUserId(uuid.toString());
            accountChapterEntity.setChapterId(cid);
            accountChapterEntity.setChapterLevel(x);
            accountChapterEntity.setStatus("Incomplete");
            accountChapterEntities.add(accountChapterEntity);
            x++;
        }
        accountChapterRepository.saveAll(accountChapterEntities);

    }

    public List<String> fetchCid(){
        return Arrays.asList("4d4d61d2-f3fb-11ee-9b08-047c16a4fc60",
                "4d4d69d2-f3fb-11ee-9b08-047c16a4fc60",
                "4d4d6aec-f3fb-11ee-9b08-047c16a4fc60",
                "4d4d6b41-f3fb-11ee-9b08-047c16a4fc60");
    }

    public void sendEmailRegistrasi(String email, String username) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        helper.setTo(email); // Replace with your email address
        helper.setSubject("Notifikasi Registrasi Akun");
        String body = "<html><body><p>Hai, </p>"+ "<br>"
                + "<p>Email ini telah ditambahkan ke dalam akun dengan username : <b>"+ username +"</b> </p></body></html>";
        helper.setText(body, true);
        javaMailSender.send(message);
        System.out.println("Success send email Registrasi");
    }


}
