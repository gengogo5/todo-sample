package com.example.todo

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloController {

    @CrossOrigin("http://localhost:8081")
    @GetMapping
    fun getHello() :String {
        return "Hello, World"
    }
}