package com.example.sbb7.Question;

import com.example.sbb7.Answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200) // 길이를 200으로 제한한다.
    private String subject;

    @Column(columnDefinition = "text")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
    // Answer 객체들로 구성된 List를 answerList 이름으로 Question 에 추가한다
    // mappedBy 는 참조 엔티티의 속성명을 정의한다.
    // cascade = CascadeType.REMOVE 는 질문을 삭제하면 그에 달린 답변들도 모두 삭제한다는 의미이다.





}
