package pro.sky.skypro.coursework.question.answer.service;

import org.springframework.stereotype.Service;
import pro.sky.skypro.coursework.question.answer.exception.QuestionAlreadyAddedException;
import pro.sky.skypro.coursework.question.answer.exception.QuestionNotFoundException;
import pro.sky.skypro.coursework.question.answer.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {

    private final Random random;

    private final Set<Question> questions;

    public JavaQuestionService() {
        this.random = new Random();
        this.questions = new HashSet<>();
    }

    public Set<Question> allQuestion() {
        return new HashSet<>(questions);
    }

    @Override
    public Question addQuestion(String question, String answer) {
        return addQuestion(new Question(question,answer));
    }

    @Override
    public Question addQuestion(Question question) {
        if (!questions.add(question)) {
            throw new QuestionAlreadyAddedException("Такой вопрос есть");
        }
        return question;
    }

    @Override
    public Question removeQuestion(Question question) {
        if (!questions.remove(question)) {
            throw new QuestionNotFoundException("Такой вопрос не найден");
        }
        return question;
    }

    @Override
    public Collection<Question> getAllQuestion() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.size()==0) {
            return null;
        }
        return allQuestion().stream().skip(random.nextInt(questions.size()))
                .findAny()
                .orElse(null);
    }
}
