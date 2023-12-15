package com.example.blog_swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(tags = "Sample API", description = "Sample API Operations")
public class BlogController {
    @GetMapping("/hello")
    @ApiOperation("Endpoint to greet the world")
    public String sayHello() {
        return "Hello, World!";
    }

}
