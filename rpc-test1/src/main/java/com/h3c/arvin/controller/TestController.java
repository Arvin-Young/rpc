package com.h3c.arvin.controller;

import com.h3c.arvin.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    //@Autowired
    TestService testService;

    @GetMapping("/test")
    public String test() {
        testService.test();
        return "success";
    }
}
