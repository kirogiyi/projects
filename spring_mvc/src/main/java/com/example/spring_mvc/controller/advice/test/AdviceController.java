package com.example.spring_mvc.controller.advice.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/advice")
public class AdviceController {
    @GetMapping("/test")
    public String test(Date date, ModelMap modelMap) {
        System.out.println(modelMap.get("project_name"));
        throw new RuntimeException("Jump to controller advice.");
    }
}
