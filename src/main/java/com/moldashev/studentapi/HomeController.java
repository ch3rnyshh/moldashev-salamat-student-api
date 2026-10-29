package com.moldashev.studentapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() { return "Student API by Moldashev Salamat | version 1.0"; }
}
