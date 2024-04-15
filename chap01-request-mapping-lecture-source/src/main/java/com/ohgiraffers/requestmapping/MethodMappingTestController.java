package com.ohgiraffers.requestmapping;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MethodMappingTestController {


    // 1. 메소드 방식 미지정
    @RequestMapping("/menu/regist")
    public String registMenu(Model model /*HttpServletRequest request*/) {

        model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출됨...");


//        request.setAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출됨...");


        /* 필기.
            Thymeleaf 의존성을 추가하게 되면
            ThymeleafViewResolver 라는 녀석이 생기게 된다.
            접두사 /resources/templates
            접미사 .html 붙여줌
         */

        return "mappingResult";
    }

//    2. 메소드 방식 지정

    @RequestMapping(value = "/menu/modify", method = RequestMethod.GET)
    public String modifyMenu(Model model) {

        model.addAttribute("message","GET 방식의 메뉴 수정용 핸들러 메소드 호출함...");

        return "mappingResult";
    }

//    3. 요청 메소드 전용 어노테이션(스프링 4.3 버전부터 지원)
    /* 필기.
        요청 메소드      어노테이션
        POST            @POSTMapping
        GET             @GETMapping
        PUT             @PUTMapping
        DELETE          @DELETEMapping
        PATCH           @PatchMapping
     */
    @DeleteMapping("/menu/delete")
    public String deleteMenu(Model model){

        model.addAttribute("message","GET 방식의 삭제용 핸들러 메소드 호출함...");

        return "mappingResult";
    }

    @PostMapping("/menu/delete")
    public String deleteMenuPost(Model model){

        model.addAttribute("message","POST 방식의 삭제용 핸들러 메소드 호출함...");

        return "mappingResult";
    }
}
