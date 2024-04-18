package com.project.sbLearn.Service;

import com.project.sbLearn.Entity.AccountEntity;
import com.project.sbLearn.Repository.AccountRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Random;

@Service
public class ResetPassService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender javaMailSender;
    private String generatedOtp = null;

    public boolean isEmailAvail(String email){
        return accountRepository.existsByEmail(email);
    }

    public String generateOtp(){
        int length = 6;
        String digit = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder randomString = new StringBuilder(length);
        Random random = new Random();

        for(int i = 0; i < length;i++){
            int index = random.nextInt(digit.length());
            randomString.append(digit.charAt(index));
        }
        return randomString.toString();

    }
    public void sendEmailOtp(String email, String sessionOtp) throws MessagingException {
        String name = accountRepository.findByEmail(email).getName();
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        helper.setTo(email); // Replace with your email address
        helper.setSubject("Reset Password");
        String body = "<html><body><p>Hai, <b>"+ name +"</b> </p>"+ "<br>"
                    + "<p>Berikut merupakan kode 6 digit yang dapat digunakan pada halaman Password Baru : <b>"+ sessionOtp +"</b> </p></body></html>";
        helper.setText(body, true);
        javaMailSender.send(message);
        System.out.println("Success send email OTP");
    }
    public boolean validatePass(String password, String confirmPassword){
        return password.equals(confirmPassword);
    }
    public boolean checkOldPass(String password, String email){
        return passwordEncoder.matches(password, accountRepository.findByEmail(email).getPassword());
    }
    public void savePassword(String newPassword, String email){
        String hashedPass = passwordEncoder.encode(newPassword);
        AccountEntity accountEntity = accountRepository.findByEmail(email);
        accountEntity.setPassword(hashedPass);
        accountRepository.save(accountEntity);
        System.out.println("reset pass success save to db");
    }


}
