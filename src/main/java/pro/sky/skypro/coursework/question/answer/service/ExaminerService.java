package pro.sky.skypro.coursework.question.answer.service;

import pro.sky.skypro.coursework.question.answer.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestion(int amount);
}
