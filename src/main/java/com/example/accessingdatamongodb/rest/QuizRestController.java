package com.example.accessingdatamongodb.rest;

import com.example.accessingdatamongodb.data.Question;
import com.example.accessingdatamongodb.data.Quiz;
import com.example.accessingdatamongodb.data.Results;
import com.example.accessingdatamongodb.repository.QuizRepository;
import com.example.accessingdatamongodb.repository.ResultRepository;
import com.example.accessingdatamongodb.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class QuizRestController {
    @Autowired
    QuizService quizService;
    @Autowired
    ResultRepository resultRepository;
    @GetMapping("/quiz")
    public Question quizzHandler(@RequestParam("id") String id, @RequestParam("number") int number)
    {
        System.out.println(id+ " " + number);
        Quiz quiz= quizService.findQuizById(id);

        quiz.getQuestions().get(number).setAnswer(null);
        return quiz.getQuestions().get(number);
    }
    @PostMapping("/addQuiz")
    public void quizzHandler(@RequestBody Quiz response)
    {
        response.setId(java.util.UUID.randomUUID().toString());
        quizService.save(response);
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
