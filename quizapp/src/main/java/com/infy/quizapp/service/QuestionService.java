package com.infy.quizapp.service;

import com.infy.quizapp.Questions;
import com.infy.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Questions> getAllQuestions() {
        return questionDao.findAll();
    }
}
