package com.example.firstproject.dto;

import com.example.firstproject.entitiy.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private Long id;
    private String title; //제목을 받을 필드
    private String content; //내용을 받을 필드

    public Article toEntitiy() {
        return new Article(id,title,content);
    }
}
