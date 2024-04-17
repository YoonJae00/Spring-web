package com.ohgiraffers.exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* 필기.
    전역에 대한 예외 처리를 담당하는 친구이다.
    여러 컨트롤러에서 발생할 수 있는 예외(Exception) 을 한 곳에서 처리할 수 있다
    코드의 중복을 줄이고 하나의 중앙 클래스에서 효율적으로 관리하기 위해 사용된다.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /* 필기.
        이 곳은 ExceptionHandler 들의 모임하는 장소이다.
     */
    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException exception) {

        System.out.println("Global 레벨의 exception 처리");
        return "error/nullPointer";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String memberRegistExceptionHandler(MemberRegistException exception, Model model) {

        System.out.println("Global 레벨의 exception 처리");
        model.addAttribute("exception", exception);

        return "error/memberRegist";
    }

    /* 필기.
        상위 타입인 Exception 을 이용하면 구체적으로 작성하지 않은 타입의 예외가
        발생하더라도 처리가 가능해진다. -> default 처리 용도로 사용할 수 있다.
     */
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception exception) {

        return "error/default";
    }
}
