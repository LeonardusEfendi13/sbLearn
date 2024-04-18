package com.project.sbLearn.Controller;


import com.project.sbLearn.Entity.*;
import com.project.sbLearn.Repository.AccountLessonRepository;
import com.project.sbLearn.Repository.AccountRepository;
import com.project.sbLearn.Service.ChapterService;
import com.project.sbLearn.Service.LessonService;
import com.project.sbLearn.Service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class ChapterController {
    @Autowired
    ChapterService chapterService;
    @Autowired
    LoginService loginService;
    @Autowired
    LessonService lessonService;
    @Autowired
    AccountLessonRepository accountLessonRepository;
    @GetMapping("/chapter1Mulai")
    public String startChapter1(HttpSession session){
        ChapterEntity chapterEntity = chapterService.getChapterId(1);
        AccountEntity accountEntity = loginService.getNameFromLogin((String) session.getAttribute("username"));
        String uid = accountEntity.getUid();
        String cid = chapterEntity.getCId();
        System.out.println("CID : "+ cid);
        System.out.println("UID : "+ uid);
        List<LessonEntity> lessons =  lessonService.displayLesson(cid);
        session.setAttribute("lessons1", lessons);
        System.out.println("LESSON question  : " + lessons);
        chapterService.setChapterStatus(uid, cid, "In Progress");
        AccountLessonEntity accountLessonEntity =  accountLessonRepository.findByUserIdAndLessonId(uid, "fbbc6d6b-f3fe-11ee-9b08-047c16a4fc60");
        if(accountLessonEntity == null ){
            session.setAttribute("lihatc1", "tidakLihat");
            System.out.println("GAADA DATA");
            return "redirect:/Chapter1/Lesson1";
        }else {
            session.setAttribute("lihatc1", "lihat");
            System.out.println("ADA DATA");
            return "redirect:/Chapter1/Lesson1/Show";
        }
    }

    @GetMapping("/chapter2Mulai")
    public String startChapter2(HttpSession session){
        ChapterEntity chapterEntity = chapterService.getChapterId(2);
        AccountEntity accountEntity = loginService.getNameFromLogin((String) session.getAttribute("username"));
        String uid = accountEntity.getUid();
        String cid = chapterEntity.getCId();
        System.out.println("CID : "+ cid);
        System.out.println("UID : "+ uid);
        List<LessonEntity> lessons =  lessonService.displayLesson(cid);
        session.setAttribute("lessons2", lessons);
        session.setAttribute("nyawaAkun", accountEntity.getLife());
        System.out.println("LESSON question  : " + lessons);
        chapterService.setChapterStatus(uid, cid, "In Progress");
        AccountLessonEntity accountLessonEntity =  accountLessonRepository.findByUserIdAndLessonId(uid, "fbbc83d9-f3fe-11ee-9b08-047c16a4fc60");
        if(accountLessonEntity == null ){
            session.setAttribute("lihatc2", "tidakLihat");
            System.out.println("GAADA DATA");
            return "redirect:/Chapter2/Lesson1";
        }else {
            session.setAttribute("lihatc2", "lihat");
            System.out.println("ADA DATA");
            return "redirect:/Chapter2/Lesson1/Show";
        }
    }
    @GetMapping("/chapter3Mulai")
    public String startChapter3(HttpSession session){
        ChapterEntity chapterEntity = chapterService.getChapterId(3);
        AccountEntity accountEntity = loginService.getNameFromLogin((String) session.getAttribute("username"));
        String uid = accountEntity.getUid();
        String cid = chapterEntity.getCId();
        System.out.println("CID : "+ cid);
        System.out.println("UID : "+ uid);
        List<LessonEntity> lessons =  lessonService.displayLesson(cid);
        session.setAttribute("lessons3", lessons);
        session.setAttribute("nyawaAkun", accountEntity.getLife());
        System.out.println("LESSON question  : " + lessons);
        chapterService.setChapterStatus(uid, cid, "In Progress");
        AccountLessonEntity accountLessonEntity =  accountLessonRepository.findByUserIdAndLessonId(uid, "fbbc8506-f3fe-11ee-9b08-047c16a4fc60");
        if(accountLessonEntity == null ){
            session.setAttribute("lihatc3", "tidakLihat");
            System.out.println("GAADA DATA");
            return "redirect:/Chapter3/Lesson1";
        }else {
            session.setAttribute("lihatc3", "lihat");
            System.out.println("ADA DATA");
            return "redirect:/Chapter3/Lesson1/Show";
        }
    }

    @GetMapping("/chapter4Mulai")
    public String startChapter4(HttpSession session){
        ChapterEntity chapterEntity = chapterService.getChapterId(4);
        AccountEntity accountEntity = loginService.getNameFromLogin((String) session.getAttribute("username"));
        String uid = accountEntity.getUid();
        String cid = chapterEntity.getCId();
        System.out.println("CID : "+ cid);
        System.out.println("UID : "+ uid);
        List<LessonEntity> lessons =  lessonService.displayLesson(cid);
        session.setAttribute("lessons4", lessons);
        session.setAttribute("nyawaAkun", accountEntity.getLife());
        System.out.println("LESSON question  : " + lessons);
        chapterService.setChapterStatus(uid, cid, "In Progress");
        AccountLessonEntity accountLessonEntity =  accountLessonRepository.findByUserIdAndLessonId(uid, "fbbce79b-f3fe-11ee-9b08-047c16a4fc60");
        if(accountLessonEntity == null ){
            session.setAttribute("lihatc4", "tidakLihat");
            System.out.println("GAADA DATA");
            return "redirect:/Chapter4/Lesson1";
        }else {
            session.setAttribute("lihatc4", "lihat");
            System.out.println("ADA DATA");
            return "redirect:/Chapter4/Lesson1/Show";
        }
    }

    @GetMapping("/chapter1Lihat")
    public String lihatChapter1(HttpSession session){
        ChapterEntity chapterEntity = chapterService.getChapterId(1);
        AccountEntity accountEntity = loginService.getNameFromLogin((String) session.getAttribute("username"));
        String uid = accountEntity.getUid();
        String cid = chapterEntity.getCId();
        System.out.println("CID : "+ cid);
        System.out.println("UID : "+ uid);
        List<LessonEntity> lessons =  lessonService.displayLesson(cid);
        session.setAttribute("lessons1", lessons);
        session.setAttribute("lihatc1", "lihat");
        return "redirect:/Chapter1/Lesson1/Show";
    }

    @GetMapping("/chapter2Lihat")
    public String lihatChapter2(HttpSession session){
        ChapterEntity chapterEntity = chapterService.getChapterId(2);
        AccountEntity accountEntity = loginService.getNameFromLogin((String) session.getAttribute("username"));
        String uid = accountEntity.getUid();
        String cid = chapterEntity.getCId();
        System.out.println("CID : "+ cid);
        System.out.println("UID : "+ uid);
        List<LessonEntity> lessons =  lessonService.displayLesson(cid);
        session.setAttribute("lessons2", lessons);
        session.setAttribute("lihatc2", "lihat");
        return "redirect:/Chapter2/Lesson1/Show";
    }

    @GetMapping("/chapter3Lihat")
    public String lihatChapter3(HttpSession session){
        ChapterEntity chapterEntity = chapterService.getChapterId(3);
        AccountEntity accountEntity = loginService.getNameFromLogin((String) session.getAttribute("username"));
        String uid = accountEntity.getUid();
        String cid = chapterEntity.getCId();
        System.out.println("CID : "+ cid);
        System.out.println("UID : "+ uid);
        List<LessonEntity> lessons =  lessonService.displayLesson(cid);
        session.setAttribute("lessons3", lessons);
        session.setAttribute("lihatc3", "lihat");
        return "redirect:/Chapter3/Lesson1/Show";
    }

    @GetMapping("/chapter4Lihat")
    public String lihatChapter4(HttpSession session){
        ChapterEntity chapterEntity = chapterService.getChapterId(4);
        AccountEntity accountEntity = loginService.getNameFromLogin((String) session.getAttribute("username"));
        String uid = accountEntity.getUid();
        String cid = chapterEntity.getCId();
        System.out.println("CID : "+ cid);
        System.out.println("UID : "+ uid);
        List<LessonEntity> lessons =  lessonService.displayLesson(cid);
        session.setAttribute("lessons4", lessons);
        session.setAttribute("lihatc4", "lihat");
        return "redirect:/Chapter4/Lesson1/Show";
    }

    @GetMapping("/chapter1Finish")
    public String finishChapter1(HttpSession session){
        ChapterEntity chapterEntity = chapterService.getChapterId(1);
        AccountEntity accountEntity = loginService.getNameFromLogin((String) session.getAttribute("username"));
        String uid = accountEntity.getUid();
        String cid = chapterEntity.getCId();
        chapterService.setChapterStatus(uid, cid, "Complete");
        return "redirect:/home";
    }

    @GetMapping("/chapter2Finish")
    public String finishChapter2(HttpSession session){
        ChapterEntity chapterEntity = chapterService.getChapterId(2);
        AccountEntity accountEntity = loginService.getNameFromLogin((String) session.getAttribute("username"));
        String uid = accountEntity.getUid();
        String cid = chapterEntity.getCId();
        chapterService.setChapterStatus(uid, cid, "Complete");
        return "redirect:/home";
    }
    @GetMapping("/chapter3Finish")
    public String finishChapter3(HttpSession session){
        ChapterEntity chapterEntity = chapterService.getChapterId(3);
        AccountEntity accountEntity = loginService.getNameFromLogin((String) session.getAttribute("username"));
        String uid = accountEntity.getUid();
        String cid = chapterEntity.getCId();
        chapterService.setChapterStatus(uid, cid, "Complete");
        return "redirect:/home";
    }

    @GetMapping("/chapter4Finish")
    public String finishChapter4(HttpSession session){
        ChapterEntity chapterEntity = chapterService.getChapterId(4);
        AccountEntity accountEntity = loginService.getNameFromLogin((String) session.getAttribute("username"));
        String uid = accountEntity.getUid();
        String cid = chapterEntity.getCId();
        chapterService.setChapterStatus(uid, cid, "Complete");
        return "redirect:/home";
    }


}
