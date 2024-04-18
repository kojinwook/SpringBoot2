package com.example.sbb7.Answer;

import com.example.sbb7.Question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
// final 이 붙은 속성을 포함하는 생성자를 자동으로 만들어줌
@Service
public class AnswerService {
    @Autowired
    private final AnswerRepository answerRepository;

    public void create(Question question, String content){
        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setCreateDate(LocalDateTime.now());
        answer.setContent(content);
        this.answerRepository.save(answer);
    // 답변을 생성 Question 에 대한 답변의 내용을 적음
    // mobile 과 web 에서 동시에서 쓰기위해서 Service 에 저장함
    }



}
