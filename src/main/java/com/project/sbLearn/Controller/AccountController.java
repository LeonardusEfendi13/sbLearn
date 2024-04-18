package com.project.sbLearn.Controller;

import com.project.sbLearn.Entity.AccountEntity;
import com.project.sbLearn.Repository.AccountRepository;
import com.project.sbLearn.Service.LoginService;
import com.project.sbLearn.Service.RegisterService;
import com.project.sbLearn.Service.ResetPassService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@AllArgsConstructor
public class AccountController {
    @Autowired
    LoginService loginService;
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RegisterService registerService;
    @Autowired
    ResetPassService resetPassService;

    //    LOGIN LOGOUT
    @GetMapping("/log_in")
    public String showLoginAfterLogout(Model model) {
        model.addAttribute("error", "Berhasil Log out");
        return "login"; // Return the login page
    }

    @GetMapping("/AfterRegist")
    public String showLoginAfterRegis(Model model) {
        model.addAttribute("success", "Akun berhasil ditambah, silakan login");
        return "login";
    }

    @GetMapping("/AfterReset")
    public String showLoginAfterReset(Model model) {
        model.addAttribute("success", "Reset Password berhasil, silakan login");
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        RedirectAttributes redirectAttributes,
                        Model model,
                        HttpSession session) {
        if (loginService.loginCheck(username, password) && !username.isEmpty() && !password.isEmpty()) {
            AccountEntity accountEntity = loginService.getNameFromLogin(username);
            session.setAttribute("nameNavbar", accountEntity.getName());
            session.setAttribute("uuid", accountEntity.getUid());
            System.out.println("SESSION START : " + username);
            System.out.println("SESSION START uuid : " + session.getAttribute("uuid"));
            session.setAttribute("username", username);
            session.setAttribute("passwordLogin", password);
            return "redirect:/home";
        } else {
            // If login fails, redirect back to login page with an error message
            model.addAttribute("error", "Username atau Password salah");
            return "/login";
        }
    }

    @GetMapping("/tambahLifec1l1")
    public String tambahLifec1l1(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter1/Lesson1";
    }

    @GetMapping("/tambahLifec1l1Answer")
    public String tambahLifec1l1Answer(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter1/Lesson1/Show";
    }

    @GetMapping("/tambahLifec1l2")
    public String tambahLifec1l2(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter1/Lesson2";
    }

    @GetMapping("/tambahLifec1l2Answer")
    public String tambahLifec1l2Answer(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter1/Lesson2/Show";
    }

    @GetMapping("/tambahLifec1l3")
    public String tambahLifec1l3(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter1/Lesson3";
    }

    @GetMapping("/tambahLifec1l3Answer")
    public String tambahLifec1l3Answer(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter1/Lesson3/Show";
    }

    //
    @GetMapping("/tambahLifec2l1")
    public String tambahLifec2l1(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter2/Lesson1";
    }

    @GetMapping("/tambahLifec2l1Answer")
    public String tambahLifec2l1Answer(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter2/Lesson1/Show";
    }

    @GetMapping("/tambahLifec2l2")
    public String tambahLifec2l2(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter2/Lesson2";
    }

    @GetMapping("/tambahLifec2l2Answer")
    public String tambahLifec2l2Answer(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter2/Lesson2/Show";
    }

    @GetMapping("/tambahLifec2l3")
    public String tambahLifec2l3(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter2/Lesson3";
    }

    @GetMapping("/tambahLifec2l3Answer")
    public String tambahLifec2l3Answer(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter2/Lesson3/Show";
    }

    //
//
    @GetMapping("/tambahLifec3l1")
    public String tambahLifec3l1(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter3/Lesson1";
    }

    @GetMapping("/tambahLifec3l1Answer")
    public String tambahLifec3l1Answer(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter3/Lesson1/Show";
    }

    @GetMapping("/tambahLifec3l2")
    public String tambahLifec3l2(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter3/Lesson2";
    }

    @GetMapping("/tambahLifec3l2Answer")
    public String tambahLifec3l2Answer(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter3/Lesson2/Show";
    }

    @GetMapping("/tambahLifec3l3")
    public String tambahLifec3l3(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter3/Lesson3";
    }

    @GetMapping("/tambahLifec3l3Answer")
    public String tambahLifec3l3Answer(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter3/Lesson3/Show";
    }
    @GetMapping("/tambahLifec3l4")
    public String tambahLifec3l4(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter3/Lesson4";
    }
    @GetMapping("/tambahLifec3l4Answer")
    public String tambahLifec3l4Answer(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter3/Lesson4/Show";
    }

//
//
@GetMapping("/tambahLifec4l1")
public String tambahLifec4l1(HttpSession session) {
    AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
    int tambah = user.getLife() + 1;
    int KurangGold = user.getGold() - 20;
    user.setLife(tambah);
    user.setGold(KurangGold);
    accountRepository.save(user);
    return "redirect:/Chapter4/Lesson1";
}

    @GetMapping("/tambahLifec4l1Answer")
    public String tambahLifec4l1Answer(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter4/Lesson1/Show";
    }

    @GetMapping("/tambahLifec4l2")
    public String tambahLifec4l2(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter4/Lesson2";
    }

    @GetMapping("/tambahLifec4l2Answer")
    public String tambahLifec4l2Answer(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter4/Lesson2/Show";
    }

    @GetMapping("/tambahLifec4l3")
    public String tambahLifec4l3(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter4/Lesson3";
    }

    @GetMapping("/tambahLifec4l3Answer")
    public String tambahLifec4l3Answer(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter4/Lesson3/Show";
    }

    @GetMapping("/tambahLifec4l4")
    public String tambahLifec4l4(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter4/Lesson4";
    }
    @GetMapping("/tambahLifec4l4Answer")
    public String tambahLifec4l4Answer(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/Chapter4/Lesson4/Show";
    }

    @GetMapping("/tambahLifeProfil")
    public String tambahLifeProfil(HttpSession session) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        int tambah = user.getLife() + 1;
        int KurangGold = user.getGold() - 20;
        user.setLife(tambah);
        user.setGold(KurangGold);
        accountRepository.save(user);
        return "redirect:/profile";
    }

//

    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        session.invalidate();
        System.out.println("SUCCESS INVALIDATE CACHE");
        return "redirect:/log_in";
    }

    //    REGISTER
    @PostMapping("/register")
    public String register(@RequestParam("name") String InputName,
                           @RequestParam("username") String InputUsername,
                           @RequestParam("email") String InputEmail,
                           @RequestParam("password") String InputPassword,
                           Model model) {
        if (InputName.isEmpty() || InputUsername.isEmpty() || InputEmail.isEmpty() || InputPassword.isEmpty()) {
            model.addAttribute("error", "Data tidak boleh kosong.");
            return "register";
        } else {
            if (registerService.isDuplicateUsername(InputUsername)) {
                model.addAttribute("error", "Username telah digunakan.");
                return "register";
            } else if (registerService.isDuplicateEmail(InputEmail)) {
                model.addAttribute("error", "Email telah digunakan.");
                return "register";
            } else {
                registerService.registerUser(InputName, InputUsername, InputEmail, InputPassword);
                System.out.println("SUCCESS REGISTER");
                try {
                    registerService.sendEmailRegistrasi(InputEmail, InputUsername);
                    System.out.println("sukses kirim email ke : " + InputEmail);
                    return "redirect:/AfterRegist";
                } catch (MessagingException e) {
                    System.out.println("Failed to send Email : " + e.getMessage());
                    return "register";
                }
            }
        }

    }

    //SEND EMAIL OTP
    @PostMapping("/sendOtp")
    public String sendOTP(@RequestParam("email") String email,
                          Model model, HttpSession session) {
        if (resetPassService.isEmailAvail(email)) {
            session.setAttribute("emailTo", email);
            String storedOtp = resetPassService.generateOtp();
            session.setAttribute("generatedOtp", storedOtp);
            try {
                resetPassService.sendEmailOtp(email, storedOtp);
                System.out.println("sukses kirim otp : " + storedOtp);
                return "redirect:/OTPResetPassword";
            } catch (MessagingException e) {
                System.out.println("Failed to send Email : " + e.getMessage());
                return "redirect:/emailOtp";
            }
        } else {
            model.addAttribute("notFound", "Email tidak ditemukan.");
            return "/emailOtp";
        }
    }

    @PostMapping("/resendOtp")
    public String resendOtp(HttpSession session) {
        System.out.println("otw kirim email : " + (String) session.getAttribute("emailTo"));
        String storedOtp = resetPassService.generateOtp();
        session.setAttribute("generatedOtp", storedOtp);
        try {
            resetPassService.sendEmailOtp((String) session.getAttribute("emailTo"), (String) session.getAttribute("generatedOtp"));
            System.out.println("sukses resend otp : " + storedOtp);
        } catch (MessagingException e) {
            System.out.println("Failed to send Email : " + e.getMessage());
        }
        return "redirect:/OTPResetPassword";
    }

    @PostMapping("/validateOtp")
    public String validateOtp(@RequestParam("otp") String InputOtp,
                              Model model,
                              HttpSession session) {
        String storedOtp = (String) session.getAttribute("generatedOtp");

        if (InputOtp.equalsIgnoreCase(storedOtp)) {
            System.out.println("COCOK : " + storedOtp + " vs " + InputOtp);
            session.removeAttribute("generatedOtp");
            return "redirect:/resetPassword";
        } else {
            System.out.println("GA COCOK : " + storedOtp + " vs " + InputOtp);
            model.addAttribute("notMatch", "OTP Tidak Sesuai.");
            return "newPasswordOTP";
        }
    }

    @PostMapping("/saveNewPassword")
    public String saveNewPassword(@RequestParam("passwordnew") String inputPassword,
                                  @RequestParam("passwordconfirm") String inputPasswordConfirm,
                                  HttpSession session,
                                  Model model) {
        if(!inputPassword.equals(" ") || !inputPasswordConfirm.equals(" ")){
            if (resetPassService.validatePass(inputPassword, inputPasswordConfirm)) {
                if (!resetPassService.checkOldPass(inputPassword, (String) session.getAttribute("emailTo"))) {
                    System.out.println("EMAIL MASIH ADA : " + session.getAttribute("emailTo"));
                    resetPassService.savePassword(inputPassword, (String) session.getAttribute("emailTo"));
                    session.removeAttribute("emailTo");
                    return "redirect:/AfterReset";
                } else {
                    System.out.println("password lama gabole sama dengan password baru");
                    model.addAttribute("samePass", "Password lama tidak boleh sama dengan password baru.");
                    return "newPassword";
                }
            } else {
                return "/resetPassword";
            }
        }else{
            System.out.println("password gabole kosong");
            model.addAttribute("samePass", "Data tidak boleh kosong.");
            return "newPassword";
        }

    }


}
