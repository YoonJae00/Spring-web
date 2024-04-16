package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/*")
public class ResolverController {

    @GetMapping("string")
    public String stringReturning(Model model){

        model.addAttribute("forwardMessage","문자열로 뷰 반환함!");

        /* 필기.
            문자열로 뷰 이름을 반환한다는 것은 반환 후
            ThymeleafViewResolver 에게 너가 앞에 resources/template 붙이고
            뒤에는 .html 붙여 라는 의미로 해석할 수 있다.
         */

        return "result";
    }

    @GetMapping("string-redirect")
    public String stringRedirect() {

        /* 접두사로 redirect: 을 하면 forward 방식이 아닌
            redirect 를 시켜준다.
         */
        return "redirect:/";
    }

    /* 필기.
        redirect 일어난다 -> 재요청이 발생하기 때문에 request 의 scope 는 소멸된다.
        하지만 스프링에서는 RedirectAttributes 타입을 통해 redirect 시 속성 ㄱ밧을
        저장할 수 있도록 하는 기능을 한다.
     */
    @GetMapping("string-redirect-attribute")
    public String stringRedirectFlashAttr(RedirectAttributes rttr) {

        /* 필기.
            리다이렉트 시 flash 영역에 담아서 redirect 를 할 수 있다.
            자동으로 모델에 추가되기 때문에 request 값을 꺼내면 된다.
            세션에 임시로 값을 담고 소멸하는 방식이기 때문에 session 에 동일한
            키값이 존재하면 안된다.
         */
        rttr.addFlashAttribute("flashMessage1","리다이렉트 attr 사용해서 redirect");

        return "redirect:/";
    }

    @GetMapping("modelandview")
    public ModelAndView modelAndViewReturning(ModelAndView mv){

        /* 필기.
            모델(값 저장)과 뷰를 합친 개념이다.
            핸들러 어댑터가 핸들러 메소드를 호출하고 반환 받은 문자열을 ModelAndView 로
            만들어서 dispatcherServlet 에 반환한다.
            이 때 문자열을 반환해도 되지만, ModelAndView 를 만들어서 반환해도 된다.
         */
        mv.addObject("forwardMessage","ModelAndView 를 이용한 모델과 뷰 반환");
        mv.setViewName("result");
        return mv;
    }

    @GetMapping("modelandview-redirect")
    public ModelAndView modelAndViewRedirect(ModelAndView mv){

        mv.setViewName("redirect:/");

        return mv;
    }

    @GetMapping("modelandview-redirect-attr")
    public ModelAndView modelAndViewRedirect(ModelAndView mv, RedirectAttributes rttr){

        rttr.addFlashAttribute("flashMessage2","ModelAndView 를 이용한 redirect attr");
        mv.setViewName("redirect://");

        return mv;
    }

}
