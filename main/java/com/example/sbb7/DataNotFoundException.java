package com.example.sbb7;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "entity not found")
// ResponseStatus : 특정 예외가 발생했을 때 응답 상태의 코드를 지정
// value = HttpStatus.NOT_FOUND : 예외가 발생했을 때 HTTP 응답 상태 코드로 NOT_FOUND를 써줌.
// reason : HTTP 응답의 이유 , 클라이언트에게 반환되는 메시지
public class DataNotFoundException extends RuntimeException{
    // RuntimeException 을 상속하여 사용자 정의 예외 클래스를 정의
    private static final long serialVersionUTD = 1L;
    // 직렬화를 위한 버전 번호
    public DataNotFoundException(String message){
        super(message);
    }
    // 예외를 생성하는 생성자 , 예외 객체를 생성할 때 메시지를 전달하여
    // 예외를 발생시킬 때의 상황을 설명

}
