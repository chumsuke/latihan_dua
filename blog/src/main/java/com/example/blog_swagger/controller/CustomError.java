package com.example.blog_swagger.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class CustomError {

    @RequestMapping("/error")
    public String handleError() {
        // Provide your custom error page or redirect logic here
        return "error";
    }

}
