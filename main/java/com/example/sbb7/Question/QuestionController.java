package com.example.sbb7.Question;

import com.example.sbb7.Answer.AnswerForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/question")
// 프리픽스(URL 의 접두사 또는 시작부분)로 /question 설정
@RequiredArgsConstructor
@Controller
public class QuestionController {
    @Autowired
    private final QuestionService questionService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Question> questionList = this.questionService.getList();
        // getList 는 모든 질문을 가지고 있기 때문에
        // 질문 목록을 가져오는 서비스를 호출한다.
        model.addAttribute("questionList",questionList);
        return "question_list";
        // model 에 questionList 라는 속성으로 질문 목록을 추가하고
       // "question_list" 템플릿값을 가져옴.
    }

    @RequestMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm){
        // id 값은 변하기 때문에 PathVariable 을 써준다.
        // 해당 질문에 대한 답변을 달기 때문에
        // 답변을 입력받는 양식의 객체인 AnswerForm 을 써준다.
        Question question = this.questionService.getQuestion(id);
        // 주어진 id에 해당 하는 질문의 존재여부를 확인한 후 오류가 없으면
        // 해당 질문을 가져온다.
        model.addAttribute("question",question);
        return "question_detail";
        // 해당 질문을 "question" 이라는 이름으로 model 에 저장하고
        // "question_detail" 템플릿값을 가져옴.
    }
    @RequestMapping("/create")
    public String questionCreate(QuestionForm questionForm){
        return "question_form";
    }
    // 이 메서드는 questionCreate 폼을 표시한다.
    // 새로운 질문을 페이지를 나타내는 것을 말한다.
    @PostMapping("/create")
    public String questionCreate(@Valid
            QuestionForm questionForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){return "question_form";}
        this.questionService.create(questionForm.getSubject(),questionForm.getContent());
        return "redirect:/question/list";
    }
    // /create 에 대한 POST 요청을 처리하여 질문을 실제로 생성
    // BindingResult 는 유효성 검사 결과를 저장하는 객체이다.
    // 이를 통해 유효성 검사 후에 오류를 처리할 수 있다.
    // bindingResult.hasErrors() : 유효성 검사에 오류가 있는지 확인
    // 오류가 있으면 "question_form" 템플릿을 리턴한다.
    // question_form 을 리턴하면 뒤에 있는 기능을 실행하지 않고 종료됨.
    // 오류가 없으면 questionService 에서 새로운 질문을 questionForm 형식에 맞게 생성하고
    // 질문을 생성하면 질문리스트로 리턴함.
}
