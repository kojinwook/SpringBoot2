package com.example.sbb7.Question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message = "제목은 필수사항입니다.")
    @Size(max=200)
    private String subject;
    // subject 를 안쓸경우 message 를 띄우고 subject 의 크기는 200을 최대로 한다.
    // 보통 제목은 짧고 간결하며 제한된 길이를 가지기 때문에 최대 길이를 지정한다.
    @NotEmpty(message = "내용은 필수사항입니다.")
    private String content;
    // content 를 안쓸경우 위의 message 를 띄운다.
    // 일반적으로 게시믈의 내용이나 댓글 내용과 같이 긴 텍스트를 저장해야 할 때는
    // 문자열의 크기를 제한하지 않는다.






}
