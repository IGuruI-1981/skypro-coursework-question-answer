package pro.sky.skypro.coursework.question.answer.service;

import pro.sky.skypro.coursework.question.answer.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
