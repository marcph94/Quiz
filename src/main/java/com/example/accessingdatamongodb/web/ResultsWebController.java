package com.example.accessingdatamongodb.web;
import com.example.accessingdatamongodb.data.Quiz;
import com.example.accessingdatamongodb.data.Results;
import com.example.accessingdatamongodb.service.QuizRepository;
import com.example.accessingdatamongodb.service.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ResultsWebController {
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    ResultRepository resultRepository;
    @GetMapping("/result")
    public String resultsHandler(@RequestParam("id") String id, Model containerToView)
    {
       Results result= resultRepository.findById(id).get();
        Quiz quiz= quizRepository.findById(result.getIdQuiz()).get();
        containerToView.addAttribute("quiz", quiz);
        containerToView.addAttribute("result", result);

        return "results.html";
    }

}
