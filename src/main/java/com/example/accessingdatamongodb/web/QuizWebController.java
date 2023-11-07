package com.example.accessingdatamongodb.web;

import com.example.accessingdatamongodb.data.Quiz;
import com.example.accessingdatamongodb.service.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuizWebController {
     @Autowired
     QuizRepository quizRepository;
    @GetMapping("/quizz")
    public String quizzHandler(@RequestParam("id") String id, Model containerToView)
    {
        Quiz quiz= quizRepository.findById(id).get();
        System.out.println(quiz);
        containerToView.addAttribute("id", id);
        containerToView.addAttribute("quiz", quiz);
        return "quizz.html";
    }

}
