package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entitiy.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ArticleController {
    @Autowired //스프링 부트가 미리 생성해 놓은 리파지터리 객체 주입
    private ArticleRepository articleRepository; // articleRepository 객체 선언
    @GetMapping("/articles/new")
    public String newArticleForm() {

        return "articles/new";
    }
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
//        System.out.println(form.toString());
        log.info(form.toString());
        // 1. DTO를 엔티티로 변환
        Article article = form.toEntitiy();
//        System.out.println(article.toString());
        log.info(article.toString());
        // 2. 리파지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article); // article 엔티티를 저장해 saved 객체에 반환
//        System.out.println(saved.toString());
        log.info(saved.toString());
        return "";
    }
    @GetMapping("/articles/{id}")
    public String show(@PathVariable long id, Model model) {
        log.info("id = " + id); // id를 잘 받았는지 확인하는 로그 찍기
        //1. id를 조회해 데이터 가져오기
        Article articleEntitiy = articleRepository.findById(id).orElse(null);
        //2. 모델에 데이터 등록하기
        model.addAttribute("article",articleEntitiy);
        //3. 뷰 페이지 반환하기
        return "articles/show";
    }
}
