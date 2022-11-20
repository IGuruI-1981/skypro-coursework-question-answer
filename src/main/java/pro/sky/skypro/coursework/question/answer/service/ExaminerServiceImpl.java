package pro.sky.skypro.coursework.question.answer.service;

import org.springframework.stereotype.Service;
import pro.sky.skypro.coursework.question.answer.exception.NotEnoughQuestionsException;
import pro.sky.skypro.coursework.question.answer.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        if (questionService.getAllQuestion().size() < amount || amount < 1) {
            throw new NotEnoughQuestionsException("Недостаточно вопросов");
        }
        Set<Question> rezult = new HashSet<>();
        while (rezult.size() < amount) {
            rezult.add(questionService.getRandomQuestion());
        }
        return rezult;
    }
}
