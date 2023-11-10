package com.example.accessingdatamongodb.web;
import com.example.accessingdatamongodb.data.Quiz;
import com.example.accessingdatamongodb.data.Results;
import com.example.accessingdatamongodb.repository.QuizRepository;
import com.example.accessingdatamongodb.repository.ResultRepository;
import com.example.accessingdatamongodb.service.QuizService;
import com.example.accessingdatamongodb.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResultsWebController {
    @Autowired
    QuizService quizService;
    @Autowired
    ResultService resultRepository;
    @GetMapping("/result")
    public String resultsHandler(@RequestParam("id") String id, Model containerToView)
    {
       Results result= resultRepository.findResultById(id);
        if(result == null )
        {
            return "redirect:404";
        }
        Quiz quiz= quizService.findQuizById(result.getIdQuiz());
        if(quiz == null )
        {
            return "redirect:404";
        }
        System.out.println(quiz + " " + result);

        containerToView.addAttribute("quiz", quiz);
        containerToView.addAttribute("result", result);

        return "results.html";
    }

}
