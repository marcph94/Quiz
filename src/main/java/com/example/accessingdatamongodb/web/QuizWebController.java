package com.example.accessingdatamongodb.web;

import com.example.accessingdatamongodb.data.Quiz;
import com.example.accessingdatamongodb.repository.QuizRepository;
import com.example.accessingdatamongodb.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuizWebController {
     @Autowired
     QuizService quizService;
    @GetMapping("/quizz")
    public String quizzHandler(@RequestParam("id") String id, Model containerToView)
    {
        Quiz quiz= quizService.findQuizById(id);
        if(quiz==null){

            return "redirect:404";        }
        System.out.println(quiz);
        containerToView.addAttribute("id", id);
        containerToView.addAttribute("quiz", quiz);
        return "quizz.html";
    }
    @GetMapping("/404")
    public String quiz404Handler()
    {

        return "404.html";
    }

}
