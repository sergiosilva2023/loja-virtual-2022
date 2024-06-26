package com.dev.backend.controller;
import java.sql.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class Hello {
    
    @GetMapping("/")
    public String hello(){
    
        return "Olá mundo spring" + new Date(2);
    }
}
