package com.project.sbLearn.Controller;

import com.project.sbLearn.Repository.AccountRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.project.sbLearn.Entity.AccountEntity;
import com.project.sbLearn.Service.LeaderboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NavigationController {
    @Autowired
    private LeaderboardService leaderboardService;
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/")
    public String defaultPage() {
        return "redirect:/home";
    }

    @GetMapping("/leaderboard")
    public String showLeaderboard(Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            List<AccountEntity> users = leaderboardService.inquiryUser();
            model.addAttribute("nameNavbar", (String) session.getAttribute("nameNavbar"));
            model.addAttribute("users", users);
            AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
            model.addAttribute("user", user);
            return "leaderboard";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/Chapter1/Lesson1")
    public String showLesson1c1(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
            model.addAttribute("lessons1", session.getAttribute("lessons1"));
            model.addAttribute("user", user);
            System.out.println("LIFE : " + user.getLife());
            return "c1Lesson1";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/Chapter1/Lesson2")
    public String showLesson2c1(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
            model.addAttribute("lessons1", session.getAttribute("lessons1"));
            model.addAttribute("user", user);
            return "c1Lesson2";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/Chapter1/Lesson3")
    public String showLesson3c1(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
            model.addAttribute("lessons1", session.getAttribute("lessons1"));
            model.addAttribute("user", user);
            return "c1Lesson3";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/Chapter2/Lesson1")
    public String showLesson1c2(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
            model.addAttribute("lessons2", session.getAttribute("lessons2"));
            model.addAttribute("user", user);
            return "c2Lesson1";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/Chapter2/Lesson2")
    public String showLesson2c2(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
            model.addAttribute("lessons2", session.getAttribute("lessons2"));
            model.addAttribute("user", user);
            return "c2Lesson2";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/Chapter2/Lesson3")
    public String showLesson3c2(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
            model.addAttribute("lessons2", session.getAttribute("lessons2"));
            model.addAttribute("user", user);
            return "c2Lesson3";
        } else {
            return "redirect:/login";
        }

    }

    @GetMapping("/Chapter3/Lesson1")
    public String showLesson1c3(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
            model.addAttribute("lessons3", session.getAttribute("lessons3"));
            model.addAttribute("user", user);
            return "c3Lesson1";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/Chapter3/Lesson2")
    public String showLesson2c3(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
            model.addAttribute("lessons3", session.getAttribute("lessons3"));
            model.addAttribute("user", user);
            return "c3Lesson2";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/Chapter3/Lesson3")
    public String showLesson3c3(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
            model.addAttribute("lessons3", session.getAttribute("lessons3"));
            model.addAttribute("user", user);
            return "c3Lesson3";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/Chapter3/Lesson4")
    public String showLesson4c3(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
            model.addAttribute("lessons3", session.getAttribute("lessons3"));
            model.addAttribute("user", user);
            return "c3Lesson4";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/Chapter4/Lesson1")
    public String showLesson1c4(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
            model.addAttribute("lessons4", session.getAttribute("lessons4"));
            model.addAttribute("user", user);
            return "c4Lesson1";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/Chapter4/Lesson2")
    public String showLesson2c4(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
            model.addAttribute("lessons4", session.getAttribute("lessons4"));
            model.addAttribute("user", user);
            return "c4Lesson2";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/Chapter4/Lesson3")
    public String showLesson3c4(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
            model.addAttribute("lessons4", session.getAttribute("lessons4"));
            model.addAttribute("user", user);
            return "c4Lesson3";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/Chapter4/Lesson4")
    public String showLesson4c4(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
            model.addAttribute("lessons4", session.getAttribute("lessons4"));
            model.addAttribute("user", user);
            return "c4Lesson4";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Return the login page
    }

    @GetMapping("/resetPassword")
    public String showResetPassword() {
        return "newPassword";
    }

    @GetMapping("/OTPResetPassword")
    public String showOTPResetPassword() {
        return "newPasswordOTP";
    }

    @GetMapping("/emailOtp")
    public String showEmailOtp() {
        return "emailOtp";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }


}

