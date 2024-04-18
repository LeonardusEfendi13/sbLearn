package com.project.sbLearn.Controller;

import com.project.sbLearn.Entity.AccountEntity;
import com.project.sbLearn.Repository.AccountRepository;
import com.project.sbLearn.Service.ProfileService;
import com.project.sbLearn.Service.ResetPassService;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ProfileController {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ResetPassService resetPassService;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/profile")
    public String showProfile(Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            model.addAttribute("nameNavbar", (String) session.getAttribute("nameNavbar"));
            System.out.println("username untuk profile : " + session.getAttribute("username"));
            AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
            model.addAttribute("user", user);
            return "profile";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/editData")
    public String showEditDataPage(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            AccountEntity userData = accountRepository.findByUsername((String) session.getAttribute("username"));
            model.addAttribute("user", userData);
            String emailAda = (String) session.getAttribute("emailAda");
            model.addAttribute("emailAda", emailAda);
            session.removeAttribute("emailAda");
            session.removeAttribute("passwordNotMatch");
            return "editData";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/editDataProfile")
    public String editData(@RequestParam("name") String name,
                           @RequestParam("email") String email,
                           @RequestParam("passwordnew") String password,
                           Model model,
                           HttpSession session) {
        if (profileService.isEmailUnique(email, (String) session.getAttribute("uuid"))) {
            System.out.println("email unik");
            Optional<AccountEntity> existAccount = accountRepository.findByUid((String) session.getAttribute("uuid"));
            if (existAccount.isPresent()) {
                AccountEntity accountEntity = existAccount.get();
                accountEntity.setName(name);
                accountEntity.setEmail(email);
                if (password.equals("PASSWORD")) {
                    System.out.println("password tidak berubah");
                } else {
                    String hashedPass = passwordEncoder.encode(password);
                    accountEntity.setPassword(hashedPass);
                    System.out.println("SUCCESS HASH PASS EDIT DATA");
                }
                accountRepository.save(accountEntity);
                System.out.println("success update db");
                return "redirect:/profile";
            } else {
                System.out.println((String) session.getAttribute("uuid") + "NOT FOUND");
                return "redirect:/error";
            }
        } else {
            System.out.println("email suda ada yg pake");
            session.setAttribute("emailAda", "Email sudah digunakan");
            return "redirect:/editData";
        }
    }

    @GetMapping("/avatar/{imgName}")
    public ResponseEntity<byte[]> getImageByName(@PathVariable("imgName") String imgName) {
        System.out.println("Name is : " + imgName);
        String base64Image = profileService.getImageFromDb(imgName);
        byte[] imgBytes = profileService.decodeBase64String(base64Image);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imgBytes);
    }

    @PostMapping("/changeProfilePicture")
    public String changeProfilePicture(@RequestParam("submitImgId") String imageId, HttpSession session) {
        profileService.changeProfilePicture(imageId, (String) session.getAttribute("username"));
        System.out.println("SUBMTIED IMAGE ID : " + imageId);
        return "redirect:/profile";
    }
}
