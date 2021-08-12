package com.orbanszlrd.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HomeController {
    @GetMapping("")
    public String homeResource() {
        return "Accessible by any user";
    }

    @GetMapping("user")
    public String userResource() {
        return "Accessible by registered users";
    }

    @GetMapping("admin")
    public String adminResource() {
        return "Accessible by admin users";
    }
}
