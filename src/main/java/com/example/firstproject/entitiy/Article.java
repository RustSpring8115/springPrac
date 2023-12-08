package com.example.firstproject.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    @GeneratedValue //자동 생성 기능 추가
    private Long id;
    @Column //title필드 선언, DB 테이블의 title 열과 연결됨
    private String title;
    @Column //content필드 선언, DB 테이블의 content 열과 연결됨
    private String content;



}
