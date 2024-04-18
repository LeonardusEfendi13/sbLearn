package com.project.sbLearn.Controller;

import com.project.sbLearn.Entity.AccountEntity;
import com.project.sbLearn.Entity.AccountLessonEntity;
import com.project.sbLearn.Entity.ChapterEntity;
import com.project.sbLearn.Repository.AccountLessonRepository;
import com.project.sbLearn.Repository.AccountRepository;
import com.project.sbLearn.Service.ChapterService;
import com.project.sbLearn.Service.LessonService;
import com.project.sbLearn.Service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Lesson4Controller {
    @Autowired
    LessonService lessonService;

    @Autowired
    LoginService loginService;
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ChapterService chapterService;
    @Autowired
    AccountLessonRepository accountLessonRepository;

    private List<AccountLessonEntity> accountLessonEntityList = new ArrayList<>();
    @GetMapping("/saveDataLessonC4")
    public String saveDataC3(HttpSession session){
        accountLessonRepository.saveAll(accountLessonEntityList);
        System.out.println("SUCCESS SAVE account LESSON DATABASE");
        accountLessonEntityList.clear();
        System.out.println("SUCCESS CLEAR LIST");
        ChapterEntity chapterEntity = chapterService.getChapterId(4);
        AccountEntity accountEntity = loginService.getNameFromLogin((String) session.getAttribute("username"));
        String uid = accountEntity.getUid();
        String cid = chapterEntity.getCId();
        chapterService.setChapterStatus(uid, cid, "Complete");
        return "redirect:/home";
    }
    @PostMapping("/InputDataLessonC4")
    public ResponseEntity<String> checkJawaban(@RequestBody AccountLessonEntity data, HttpSession session){
        AccountEntity accountEntity = loginService.getNameFromLogin((String) session.getAttribute("username"));
        ChapterEntity chapterEntity = chapterService.getChapterId(4);
        String cid = chapterEntity.getCId();
        String uid = accountEntity.getUid();
        chapterService.setChapterStatus(uid, cid, "In Progress");
        System.out.println("LESSON ID FROM JS : " + data.getLessonId());
        System.out.println("ANSWER DB FROM JS : " + data.getAnswersDb());
        System.out.println("ANSWER USER FROM JS : " + data.getAnswerUser());
        System.out.println("STATUS FROM JS : " + data.getStatus());
        lessonService.saveLessonToAccountLesson(uid, data.getLessonId(), data.getAnswersDb(), data.getAnswerUser(), data.getStatus());
        lessonService.updateAccount(uid, data.getStatus(), data.getLessonId());
        AccountLessonEntity accountLessonEntity = accountLessonRepository.findByUserIdAndLessonId(uid, data.getLessonId());
        String ansFromUser = accountLessonEntity.getAnswerUser();
        String ansFromDb = accountLessonEntity.getAnswersDb();
        session.setAttribute("ansFromUser", ansFromUser);
        session.setAttribute("ansFromDb", ansFromDb);
        System.out.println("success now go back to controller");
        return ResponseEntity.ok("Saved Data Lesson ID : " + data.getLessonId());
    }
    @GetMapping("/Chapter4/Lesson1/Show")
    public String showLesson1Chapter3(HttpSession session, Model model) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        AccountLessonEntity accountLessonEntity1 = accountLessonRepository.findByUserIdAndLessonId(user.getUid(),"fbbce79b-f3fe-11ee-9b08-047c16a4fc60");
        model.addAttribute("lessons4", session.getAttribute("lessons4"));
        if("lihat".equalsIgnoreCase((String) session.getAttribute("lihatc4"))){
            model.addAttribute("ansFromUser", accountLessonEntity1.getAnswerUser());
            model.addAttribute("ansFromDb", accountLessonEntity1.getAnswersDb());
        }else if("tidakLihat".equalsIgnoreCase((String) session.getAttribute("lihatc4"))){
            model.addAttribute("ansFromUser", session.getAttribute("ansFromUser"));
            model.addAttribute("ansFromDb", session.getAttribute("ansFromDb"));
        }
        model.addAttribute("user", user);
        AccountLessonEntity accountLessonEntity2 = accountLessonRepository.findByUserIdAndLessonId(user.getUid(),"fbbce7ff-f3fe-11ee-9b08-047c16a4fc60");
        if(accountLessonEntity2 == null ){
            session.setAttribute("lihatc4", "tidakLihat");
            model.addAttribute("lihatc4", session.getAttribute("lihatc4"));
            System.out.println("GAADA DATA chapter 1 lesson 2 di c3l1");
        }else {
            model.addAttribute("lihatc4", session.getAttribute("lihatc4"));
            System.out.println("ADA DATA chapter 1 lesson 2 di c3l1");
        }
        return "c4Lesson1Answer";
    }

    @GetMapping("/Chapter4/Lesson2/Show")
    public String showLesson2Chapter3(HttpSession session, Model model) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        AccountLessonEntity accountLessonEntity2 = accountLessonRepository.findByUserIdAndLessonId(user.getUid(),"fbbce7ff-f3fe-11ee-9b08-047c16a4fc60");

        model.addAttribute("lessons4", session.getAttribute("lessons4"));
        if("lihat".equalsIgnoreCase((String) session.getAttribute("lihatc4"))){
            model.addAttribute("ansFromUser", accountLessonEntity2.getAnswerUser());
            model.addAttribute("ansFromDb", accountLessonEntity2.getAnswersDb());
        }else if("tidakLihat".equalsIgnoreCase((String) session.getAttribute("lihatc4"))){
            model.addAttribute("ansFromUser", session.getAttribute("ansFromUser"));
            model.addAttribute("ansFromDb", session.getAttribute("ansFromDb"));
        }
        model.addAttribute("user", user);
        AccountLessonEntity accountLessonEntity3 = accountLessonRepository.findByUserIdAndLessonId(user.getUid(),"fbbce84a-f3fe-11ee-9b08-047c16a4fc60");
        if(accountLessonEntity3 == null ){
            session.setAttribute("lihatc4", "tidakLihat");
            model.addAttribute("lihatc4", session.getAttribute("lihatc4"));
            System.out.println("GAADA DATA chapter 1 lesson 3 di c3l1");
        }else {
            model.addAttribute("lihatc4", session.getAttribute("lihatc4"));
            System.out.println("ADA DATA chapter 1 lesson 3 di c3l1");
        }
        model.addAttribute("lihatc4", session.getAttribute("lihatc4"));
        return "c4Lesson2Answer";
    }
    @GetMapping("/Chapter4/Lesson3/Show")
    public String showLesson3Chapter3(HttpSession session, Model model) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        AccountLessonEntity accountLessonEntity = accountLessonRepository.findByUserIdAndLessonId(user.getUid(),"fbbce84a-f3fe-11ee-9b08-047c16a4fc60");

        model.addAttribute("lessons4", session.getAttribute("lessons4"));
        if("lihat".equalsIgnoreCase((String) session.getAttribute("lihatc4"))){
            model.addAttribute("ansFromUser", accountLessonEntity.getAnswerUser());
            model.addAttribute("ansFromDb", accountLessonEntity.getAnswersDb());
        }else if("tidakLihat".equalsIgnoreCase((String) session.getAttribute("lihatc4"))){
            model.addAttribute("ansFromUser", session.getAttribute("ansFromUser"));
            model.addAttribute("ansFromDb", session.getAttribute("ansFromDb"));
        }
        model.addAttribute("user", user);
        AccountLessonEntity accountLessonEntity4 = accountLessonRepository.findByUserIdAndLessonId(user.getUid(),"fbbce892-f3fe-11ee-9b08-047c16a4fc60");
        if(accountLessonEntity4 == null ){
            session.setAttribute("lihatc4", "tidakLihat");
            model.addAttribute("lihatc4", session.getAttribute("lihatc4"));
            System.out.println("GAADA DATA chapter 1 lesson 3 di c3l1");
        }else {
            model.addAttribute("lihatc4", session.getAttribute("lihatc4"));
            System.out.println("ADA DATA chapter 1 lesson 3 di c3l1");
        }
        model.addAttribute("lihatc4", session.getAttribute("lihatc4"));
        return "c4Lesson3Answer";
    }
    @GetMapping("/Chapter4/Lesson4/Show")
    public String showLesson4Chapter3(HttpSession session, Model model) {
        AccountEntity user = accountRepository.findByUsername((String) session.getAttribute("username"));
        AccountLessonEntity accountLessonEntity = accountLessonRepository.findByUserIdAndLessonId(user.getUid(),"fbbce892-f3fe-11ee-9b08-047c16a4fc60");

        model.addAttribute("lessons4", session.getAttribute("lessons4"));
        if("lihat".equalsIgnoreCase((String) session.getAttribute("lihatc4"))){
            model.addAttribute("ansFromUser", accountLessonEntity.getAnswerUser());
            model.addAttribute("ansFromDb", accountLessonEntity.getAnswersDb());
        }else if("tidakLihat".equalsIgnoreCase((String) session.getAttribute("lihatc4"))){
            model.addAttribute("ansFromUser", session.getAttribute("ansFromUser"));
            model.addAttribute("ansFromDb", session.getAttribute("ansFromDb"));
        }
        model.addAttribute("user", user);
        model.addAttribute("lihatc4", session.getAttribute("lihatc4"));
        return "c4Lesson4Answer";
    }
}
