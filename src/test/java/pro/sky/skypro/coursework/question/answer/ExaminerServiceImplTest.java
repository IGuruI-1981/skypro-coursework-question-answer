package pro.sky.skypro.coursework.question.answer;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skypro.coursework.question.answer.exception.NotEnoughQuestionsException;
import pro.sky.skypro.coursework.question.answer.model.Question;
import pro.sky.skypro.coursework.question.answer.service.ExaminerServiceImpl;
import pro.sky.skypro.coursework.question.answer.service.JavaQuestionService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final List<Question> javaQuestion = new ArrayList<>();

    @BeforeEach
    public void beforeEach() {
        javaQuestion.clear();

        javaQuestion.addAll(
                     Stream.of(new Question("Qestion1","Answer1"),
                               new Question("Qestion2","Answer2"),
                               new Question("Qestion3","Answer3"))
                              .collect(Collectors.toSet()));

        when(javaQuestionService.getAllQuestion()).thenReturn(javaQuestion);
    }

    @Test
    public void getQuestionNegativTest() {
        assertThatExceptionOfType(NotEnoughQuestionsException.class)
                .isThrownBy(() -> examinerService.getQuestion(-1));
    }

    @Test
    public void getQuestionPozitivTest() {
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                new Question("Qestion1","Answer1"),
                new Question("Qestion2","Answer2"),
                new Question("Qestion2","Answer2"),
                new Question("Qestion5","Answer5"),
                new Question("Qestion5","Answer5"),
                new Question("Qestion3","Answer3"),
                new Question("Qestion6","Answer6"));

        assertThat(examinerService.getQuestion(3))
                        .hasSize(3)
                        .containsExactlyInAnyOrder(
                                new Question("Qestion1","Answer1"),
                                new Question("Qestion2","Answer2"),
                                new Question("Qestion5","Answer5"));
    }
}
