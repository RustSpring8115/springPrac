package com.example.firstproject.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity //엔티티선언
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Article {
    @Id //엔티티의 대표값 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 생성 기능 추가
    private Long id;
    @Column //title필드 선언, DB 테이블의 title 열과 연결됨
    private String title;
    @Column //content필드 선언, DB 테이블의 content 열과 연결됨
    private String content;

    public void patch(Article article) {
        if(article.title != null)
            this.title = article.title;
        if (article.content != null)
            this.content = article.content;
    }
}
