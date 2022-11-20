package pro.sky.skypro.coursework.question.answer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skypro.coursework.question.answer.model.Question;
import pro.sky.skypro.coursework.question.answer.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {

    private final QuestionService questionService;


    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {

        return questionService.addQuestion(question,answer);
    }

    @GetMapping( "/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {

        return questionService.removeQuestion(new Question(question,answer));
    }

    @GetMapping
    public Collection<Question> getAllQuestion() {
        return questionService.getAllQuestion();
    }


}
