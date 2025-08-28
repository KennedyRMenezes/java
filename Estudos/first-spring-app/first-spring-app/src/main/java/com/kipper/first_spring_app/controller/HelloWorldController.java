package com.kipper.first_spring_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kipper.first_spring_app.domain.User;
import com.kipper.first_spring_app.service.HelloWorldService;


@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping // responde requisições em GET/hello-world
    public String helloWorld(){
        return helloWorldService.helloWorld("Kennedy");
    }

    @PostMapping("/post")
    public String helloWorldPost(@RequestBody User body) {
        
        return  "Hello World " + body.getName();
    }

    @PostMapping("/post/{id}")
    public String helloWorldPost(@PathVariable("id") String id, @RequestBody User body) {
        
        return  "Hello World " + body.getName() + " " + id;
    }
    
}
