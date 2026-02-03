package com.example.j2ee_buibinhnguyen_0302.controller;

import com.example.j2ee_buibinhnguyen_0302.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/demo")
    public String demoPage(Model model) {
        Student student = new Student(1, "Bùi Bình Nguyên");

        model.addAttribute("student", student);

        model.addAttribute("message", "Welcome Thymeleaf!");

        return "demo";
    }
}