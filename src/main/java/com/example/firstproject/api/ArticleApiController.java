package com.example.firstproject.api;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entitiy.Article;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ArticleApiController {
    @Autowired
    private ArticleService articleService; //서비스 객체 주입
    //GET
    @GetMapping("/api/articles")
    public List<Article> index() {
        return articleService.index();
    }
    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id) {
        log.info("id = " + id);
        return articleService.show(id);
    }
    //POST
    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto) {
        Article created = articleService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    //PATCH
    @PatchMapping ("api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id,
                                          @RequestBody ArticleForm dto) {
        Article updated =  articleService.update(id,dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    //DELETE
    @DeleteMapping("api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {
       Article deledted = articleService.delete(id);
       return (deledted != null) ?
               ResponseEntity.status(HttpStatus.NO_CONTENT).build():
               ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PostMapping("/api/transaction-test")
    public ResponseEntity<List<Article>> transactionTest(@RequestBody List<ArticleForm> dtos) {
        List<Article> createdList = articleService.createArticles(dtos);
        return (createdList != null) ?
                ResponseEntity.status(HttpStatus.OK).body(createdList) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
