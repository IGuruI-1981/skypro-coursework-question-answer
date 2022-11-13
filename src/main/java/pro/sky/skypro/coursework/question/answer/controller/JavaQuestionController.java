package pro.sky.skypro.coursework.question.answer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skypro.coursework.question.answer.Question;
import pro.sky.skypro.coursework.question.answer.service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/java/")
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {

        return null;
    }

    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {

        return null;
    }

    @GetMapping
    public Collection<Question> getQuestion() {

        return null;
    }


}
