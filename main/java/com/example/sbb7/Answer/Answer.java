package com.example.sbb7.Answer;

import com.example.sbb7.Question.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Answer {
    @Id // id를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 값을 일일이 입력하지 않아도 자동으로 1씩 증가
    private Integer id;

    @Column(columnDefinition = "text") // 텍스트를 열 데이터로 넣을수 있음
    private String content;

    private LocalDateTime createDate; // 현재 시간을 넣음

    @ManyToOne // N:1 관계로 질문 : N / 대답 : 1 관계를 뜼함
    private Question question;






}
