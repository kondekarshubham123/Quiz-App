package com.infy.quizapp.dao;

import com.infy.quizapp.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends JpaRepository<Questions, Integer> {

}
