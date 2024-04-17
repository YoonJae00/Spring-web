package com.ohgiraffers.interceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/*")
public class interceptorController {

    @GetMapping("stopwatch")
    public String stopwatch() throws InterruptedException {
        System.out.println("핸들러 메소드 호출함...");

        Thread.sleep(3000);

        return "stopwatch";
    }
}
