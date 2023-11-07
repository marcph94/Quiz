package com.example.accessingdatamongodb.web;

import com.example.accessingdatamongodb.data.Quiz;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddQuizWebController {

    @GetMapping("/addQuiz")
    public String addQuizzHandler()
    {

        return "addQuiz.html";
    }
}
