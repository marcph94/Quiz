package com.example.accessingdatamongodb.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
@Document("Results")
public class Results {

    @Id
    String id;

    String idQuiz;
    ArrayList<String> answers  =new ArrayList<String>();

    public Results() {
    }

    public Results(String id, String idQuiz, ArrayList<String> answers) {
        this.id = id;
        this.idQuiz = idQuiz;
        this.answers = answers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(String idQuiz) {
        this.idQuiz = idQuiz;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }


}
