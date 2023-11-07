package com.example.accessingdatamongodb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class LoginWebController {
    @GetMapping("/login")
    String login() {
        return "login";
    }
}
