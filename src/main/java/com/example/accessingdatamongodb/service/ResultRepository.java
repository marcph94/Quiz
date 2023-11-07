package com.example.accessingdatamongodb.service;

import com.example.accessingdatamongodb.data.Results;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultRepository  extends MongoRepository<Results, String> {
}
