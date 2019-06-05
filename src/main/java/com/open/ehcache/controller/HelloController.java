package com.open.ehcache.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }
}
//@RestController 注解： 该注解是 @Controller 和 @ResponseBody 注解的合体版
