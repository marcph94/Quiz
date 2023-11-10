package com.example.accessingdatamongodb.service;

import com.example.accessingdatamongodb.data.Quiz;
import com.example.accessingdatamongodb.data.Results;
import com.example.accessingdatamongodb.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResultService {
    @Autowired
ResultRepository resultRepository;

    public Results findResultById(String id){
        Optional<Results> results= resultRepository.findById(id);
        if(results.isPresent())
        {
            return  results.get();
        }
        return null;
    }
}
