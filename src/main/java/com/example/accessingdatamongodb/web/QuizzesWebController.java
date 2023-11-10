package com.example.accessingdatamongodb.web;
import com.example.accessingdatamongodb.data.Quiz;
import com.example.accessingdatamongodb.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class QuizzesWebController {
    @Autowired
    QuizRepository quizRepository;
    @GetMapping({"/quizzes", "/"})
    public String quizzHandler(Model containerToView)
    {
        List<Quiz> quizzes= quizRepository.findAll();
        System.out.println(quizzes);
        containerToView.addAttribute("quizzes", quizzes);
        return "quizzes.html";
    }

}


