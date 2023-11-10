package com.example.accessingdatamongodb.repository;

import com.example.accessingdatamongodb.data.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizRepository extends MongoRepository<Quiz, String> {
}
