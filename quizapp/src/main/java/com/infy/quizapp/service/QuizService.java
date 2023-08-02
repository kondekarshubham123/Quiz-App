package com.infy.quizapp.service;

import com.infy.quizapp.dao.QuizDao;
import com.infy.quizapp.dao.QuestionDao;
import com.infy.quizapp.model.QuestionWrapper;
import com.infy.quizapp.model.Questions;
import com.infy.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Questions> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Questions> questionsFromDb = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = questionsFromDb.stream().map((question) -> new QuestionWrapper(question.getId(), question.getQuestionTitle(), question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4())).toList();
        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }
}
