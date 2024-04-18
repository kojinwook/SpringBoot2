package com.example.sbb7.Question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
    List<Question> findBySubjectLike(String subject);

    // 리포지터리는 findBySubject 메서드를 기본적으로 제공하지 않으므로
    // QuestionRepository 인터페이스에 추가를 해준다.




}
