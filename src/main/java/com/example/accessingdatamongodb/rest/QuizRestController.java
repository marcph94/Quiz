package com.example.accessingdatamongodb.rest;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.accessingdatamongodb.data.Question;
import com.example.accessingdatamongodb.data.Quiz;
import com.example.accessingdatamongodb.data.Results;
import com.example.accessingdatamongodb.service.QuizRepository;
import com.example.accessingdatamongodb.service.ResultRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class QuizRestController {
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    ResultRepository resultRepository;
    @GetMapping("/quiz")
    public Question quizzHandler(@RequestParam("id") String id, @RequestParam("number") int number)
    {
        System.out.println(id+ " " + number);
        Quiz quiz= quizRepository.findById(id).get();
        quiz.getQuestions().get(number).setAnswer(null);
        return quiz.getQuestions().get(number);
    }
    @PostMapping("/addQuiz")
    public void quizzHandler(@RequestBody Quiz response)
    {
        response.setId(java.util.UUID.randomUUID().toString());
        quizRepository.save(response);
    }
    @PostMapping("/results")
    @ResponseBody
    public String resultsHandler(@RequestBody Results response){
       response.setId(java.util.UUID.randomUUID().toString());
        System.out.println(response.getIdQuiz());
        System.out.println(response.getAnswers());
        System.out.println(response.getId());
        resultRepository.save(response);
        return response.getId();
    }
}
