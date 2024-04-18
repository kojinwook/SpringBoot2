package com.example.sbb7.Answer;

import com.example.sbb7.Question.Question;
import com.example.sbb7.Question.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {
    @Autowired
    private final QuestionService questionService;
    @Autowired
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id,
    // Model 객체는 자바클래스와 템플릿을 연결해주는 역할을 한다,
    // id는 변하는 값이므로 @PathVariable 애너테이션을 넣어준다.
    @Valid AnswerForm answerForm, BindingResult bindingResult){
    //  Valid 는 객체의 유효성 검사를 실행하라는 의미이다.
    // content 의 항목을 지닌 폼이 전송되면 content 의 속성이 자동으로 바인딩된다.
    // 이름이 동일하여 함께 연결되어 묶이는 것이 바로 폼의 바인딩 기능이다.
    // BindingResult 는 유효성 검사 결과를 저장하는 객체이다. 이를 통해 유효성 검사 후에
    // 오류를 처리할 수 있다.

    Question question = this.questionService.getQuestion(id);
    // 주어진 id 에 대한 질문을 가져온다.
        if(bindingResult.hasErrors()){model.addAttribute("question",question);
        return "question_detail";}
        // bindingResult.hasErrors() : 유효성 검사 결과에 오류가 있는지 확인
        // 오류가 있으면 해당 질문을 model 에 추가하고 question_detail 을 반환한다.
        // question_detail 을 반환하기 위해서 model 에서 question 을 가져와서 저장함.
        this.answerService.create(question, answerForm.getContent());
        // 답변을 생성하는 서비스를 호출하고 질문과 답변 내용이 전달된다.
        return String.format("redirect:/question/detail/%s",id);}
        // 생성된 질문의 상세페이지로 리다이렉트하고 %s 에는 질문의 id 가 들어간다.



}
