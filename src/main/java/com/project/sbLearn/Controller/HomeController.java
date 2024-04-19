package com.project.sbLearn.Controller;

import com.project.sbLearn.Entity.AccountChapterEntity;
import com.project.sbLearn.Entity.AccountEntity;
import com.project.sbLearn.Entity.ChapterEntity;
import com.project.sbLearn.Repository.AccountChapterRepository;
import com.project.sbLearn.Repository.AccountRepository;
import com.project.sbLearn.Repository.ChapterRepository;
import com.project.sbLearn.Service.ChapterService;
import com.project.sbLearn.Service.ProfileService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ChapterRepository chapterRepository;

    @Autowired
    AccountChapterRepository accountChapterRepository;

    @Autowired
    ChapterService chapterService;

    @Autowired
    ProfileService profileService;


    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        if (session.getAttribute("username") != null) {
            model.addAttribute("nameNavbar", (String) session.getAttribute("nameNavbar"));
            System.out.println("ada session : " + (String) session.getAttribute("nameNavbar"));
            AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
            List<ChapterEntity> chapter = chapterRepository.findAll();
            List<AccountChapterEntity> accountChapterEntities = accountChapterRepository.findByUserIdOrderByChapterLevelAsc(user.getUid());
            model.addAttribute("user", user);
            model.addAttribute("chapter", chapter);
            model.addAttribute("accountChapter", accountChapterEntities);
            AccountChapterEntity incompleteChapter = chapterService.getFirstIncompleteChapter(user.getUid());
            profileService.setBadgeUser(user.getUid());
            if (incompleteChapter != null) {
                int firstIncompleteLvl = incompleteChapter.getChapterLevel();
                user.setCurrentChapter(firstIncompleteLvl);
                accountRepository.save(user);
                model.addAttribute("firstIncomplete", firstIncompleteLvl);
                System.out.println("INI first Incomplete : " + user.getHighestChapter());
            } else {
                System.out.println("INI pertama incomplete : " + user.getHighestChapter());
                model.addAttribute("firstIncomplete", user.getHighestChapter());
                System.out.println("abis bang");
            }
            return "home";
        } else {
            System.out.println("gada session bos");
            return "redirect:/login";
        }
    }

//    @GetMapping("")
}
