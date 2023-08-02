package com.infy.quizapp.service;

import com.infy.quizapp.Questions;
import com.infy.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<Questions> addQuestions(Questions questions) {
        return new ResponseEntity<>(questionDao.save(questions), HttpStatus.CREATED);
    }

    public ResponseEntity<List<Questions>> getAllQuestions() {
        return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<Questions>> getQuestionsByCategory(String category) {
        return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
    }

    public void deleteQuestionById(Integer id) {
        questionDao.deleteById(id);
    }
}
