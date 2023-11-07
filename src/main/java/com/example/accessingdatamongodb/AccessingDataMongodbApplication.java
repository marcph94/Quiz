package com.example.accessingdatamongodb;

import com.example.accessingdatamongodb.data.Question;
import com.example.accessingdatamongodb.data.Quiz;
import com.example.accessingdatamongodb.service.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.desktop.ScreenSleepEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.UUID;

@SpringBootApplication
public class AccessingDataMongodbApplication /*implements CommandLineRunner */{
    @Autowired
    QuizRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataMongodbApplication.class, args);
    }
/*
    @Override
    public void run(String... args) throws Exception {


        Scanner scanner = new Scanner(System.in);
        String category="";
		ArrayList<Question> questions = new ArrayList<Question>();

	for(int i=0;i<5;i++){

			System.out.println("pregunta");
            String text = scanner.nextLine();
            String opt1, opt2, opt3, opt4;
            System.out.println("a");
            opt1 = scanner.nextLine();
            System.out.println("b");
            opt2 = scanner.nextLine();
            System.out.println("c");
            opt3 = scanner.nextLine();
            System.out.println("d");
            opt4 = scanner.nextLine();
			String answer;
			System.out.println("respuesta");
			answer=scanner.nextLine();
			Question q1 = new Question(java.util.UUID.randomUUID().toString(), text, opt1,opt2, opt3, opt4, answer);
			questions.add(q1);

	}
		System.out.println("Introduce categoria");
		category = scanner.nextLine();

		Quiz quiz = new Quiz(category, questions);
		repository.save(quiz);

    }*/
}