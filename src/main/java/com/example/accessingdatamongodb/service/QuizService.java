package com.example.accessingdatamongodb.service;

import com.example.accessingdatamongodb.data.Quiz;
import com.example.accessingdatamongodb.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class QuizService {
    @Autowired
    QuizRepository quizRepository;

    public Quiz findQuizById(String id){
        Optional<Quiz> quiz= quizRepository.findById(id);
        if(quiz.isPresent())
        {
            return  quiz.get();
        }
        return null;
    }
    public  void save(Quiz response){
        quizRepository.save(response);

    }
}
