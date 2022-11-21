package pro.sky.skypro.coursework.question.answer.service;

import pro.sky.skypro.coursework.question.answer.model.Question;

import java.util.Collection;

public interface QuestionService {

    Question addQuestion(String question,String answer);

    Question addQuestion(Question question);

    Question removeQuestion(Question question);

    Collection<Question> getAllQuestion();

    Question getRandomQuestion();
}
