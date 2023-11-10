package com.example.accessingdatamongodb.repository;

import com.example.accessingdatamongodb.data.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question, String> {
}
