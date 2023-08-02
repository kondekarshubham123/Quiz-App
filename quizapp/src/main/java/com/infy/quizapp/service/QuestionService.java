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

    public Questions addQuestions(Questions questions) {
        return questionDao.save(questions);
    }

    public List<Questions> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Questions> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public void deleteQuestionById(Integer id) {
        questionDao.deleteById(id);
    }
}
