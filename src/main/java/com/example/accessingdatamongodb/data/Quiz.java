package com.example.accessingdatamongodb.data;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class Quiz {

    @Id
    String id;
    String category;
    ArrayList<Question> questions  =new ArrayList<Question>();

    public Quiz( String category, ArrayList<Question> questions) {
        this.category=category;
        this.questions = questions;
    }
    public Quiz() {
      }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", questions=" + questions +
                '}';
    }
}
