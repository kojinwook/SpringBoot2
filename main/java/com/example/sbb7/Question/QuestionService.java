package com.example.sbb7.Question;


import com.example.sbb7.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {
    @Autowired
    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }
    // getList() 메서드는 데이터베이스에 저장된 모든 질문을 검색하여 해당 리스트를 반환합니다
    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        // 주어진 id에 해당하는 질문을 Optional<Question> 형식으로 가져옴.
        if (question.isPresent()) {
            return question.get();
            // Optional 에 해당 질문이 존재하면 해당질문을 가져옴
        } else {
            throw new DataNotFoundException("question not found");
        } // Optional 에 해당 질문이 존재하지 않는다면 "질문을 찾지 못했다"는
        // DataNotFoundException 을 반환한다.
    }

    public void create(String subject , String content){
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q);
    }
    // 새로운 질문 등록하기
    // 어디에서든지 쓰기위해서 Service 에 저장함


}
