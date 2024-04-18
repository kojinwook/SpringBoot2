package com.example.sbb7.Answer;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {
    @NotEmpty(message = "내용은 필수 사항입니다.")
    // 텅 비었을 경우 위 메시지를 띄움
    private String content;
}
