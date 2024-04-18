package com.example.sbb7;

import com.example.sbb7.Answer.Answer;
import com.example.sbb7.Answer.AnswerRepository;
import com.example.sbb7.Question.Question;
import com.example.sbb7.Question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Sbb7ApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;
	@Transactional
//	메서드가 종료될 때까지 DB 세션이 유지된다
	@Test
	void testJpa() {

//		Question q1 = new Question();
//		q1.setSubject("sbb 가 무엇인가요?");
//		q1.setContent("sbb 에 대해서 알고 싶습니다.");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);  // 첫번째 질문 저장
//
//		Question q2 = new Question();
//		q2.setSubject("스프링부트 모델 질문입니다.");
//		q2.setContent("id는 자동으로 생성되나요?");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);  // 두번째 질문 저장

//		질문 조회하기
//		findByAll 메서드
//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(2,all.size());
//		Question q = all.get(0);
//		assertEquals("sb b가 무엇인가요?",q.getSubject());

//		findById 메서드
//		Optional<Question> oq = this.questionRepository.findById(1);
//		if(oq.isPresent()){
//			Question q = oq.get();
//			assertEquals("sbb 가 무엇인가요?",q.getSubject());
//		}

//		findBySubject 메서드
//		Question q = this.questionRepository.findBySubject("sbb 가 무엇인가요?");
//		assertEquals(1,q.getId());

//		findBySubjectAndContent 메서드
//		Question q = this.questionRepository.findBySubjectAndContent("sbb 가 무엇인가요?",
//		"sbb 에 대해서 알고 싶습니다.");
//		assertEquals(1,q.getId());

//		findBySubjectLike 메서드
//		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//		Question q = qList.get(0);
//		assertEquals("sbb 가 무엇인가요?",q.getSubject());

//		질문 수정하기
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get(); 질문 조회
//		q.setSubject("수정된 제목"); 질문 수정
//		this.questionRepository.save(q); 질문 저장

//		질문 삭제하기
//		assertEquals(2,this.questionRepository.count()); 현재 질문개수
//		Optional<Question> oq = this.questionRepository.findById(1); 삭제할 질문 번호
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		this.questionRepository.delete(q); 질문 삭제
//		assertEquals(1,this.questionRepository.count()); 남은 질문 개수

//		답변 저장하기
//		Optional<Question> oq = this.questionRepository.findById(2); 답변할 질문 번호
//		assertTrue(oq.isPresent());
//		Question q = oq.get(); 질문 조회
//
//		Answer a = new Answer(); 답변 생성
//		a.setContent("네 자동으로 생성됩니다.");
//		a.setCreateDate(LocalDateTime.now());
//		a.setQuestion(q);
//		this.answerRepository.save(a); 답변 저장

//		답변 조회하기
//		Optional<Answer> oa = this.answerRepository.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(2,a.getQuestion().getId());

//		질문 데이터를 통해 답변 데이터 찾기
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		List<Answer> answerList = q.getAnswerList();
		assertEquals(1,answerList.size());
		assertEquals("네 자동으로 생성됩니다.",answerList.get(0).getContent());



	}

}
