package com.example.accessingdatamongodb.service;

import com.example.accessingdatamongodb.data.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizRepository extends MongoRepository<Quiz, String> {
}
