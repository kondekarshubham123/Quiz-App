package com.infy.quizapp.controller;

import com.infy.quizapp.Questions;
import com.infy.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public List<Questions> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public List<Questions> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody Questions questions){
        questionService.addQuestions(questions);
        return "success";
    }

    @DeleteMapping("/delete")
    public String deleteQuestion(@RequestParam Integer id){
        questionService.deleteQuestionById(id);
        return "deleted";
    }

}
