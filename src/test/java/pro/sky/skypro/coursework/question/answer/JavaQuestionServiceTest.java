package pro.sky.skypro.coursework.question.answer;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skypro.coursework.question.answer.exception.QuestionAlreadyAddedException;
import pro.sky.skypro.coursework.question.answer.exception.QuestionNotFoundException;
import pro.sky.skypro.coursework.question.answer.model.Question;
import pro.sky.skypro.coursework.question.answer.service.JavaQuestionService;
import pro.sky.skypro.coursework.question.answer.service.QuestionService;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    public void addQuestion1Test() {
        javaQuestionService.addQuestion(new Question("Question", "Answer"));

        assertThatExceptionOfType(QuestionAlreadyAddedException.class)
                .isThrownBy(() -> javaQuestionService.addQuestion(new Question("Question", "Answer")));
        assertThat(javaQuestionService.getAllQuestion())
                .containsExactlyInAnyOrder(new Question("Question", "Answer"));
    }

    @Test
    public void addQuestion2Test() {
        String question = "Question";
        String answer = "Answer";
        Question quest = new Question(question, answer);
        javaQuestionService.addQuestion(question, answer);

        assertThatExceptionOfType(QuestionAlreadyAddedException.class)
                .isThrownBy(() -> javaQuestionService.addQuestion("Question", "Answer"));
        assertThat(javaQuestionService.getAllQuestion())
                .containsExactlyInAnyOrder(quest);

    }

    @Test
    public void removeQuestionTest() {
        javaQuestionService.addQuestion(new Question("Question", "Answer"));
        javaQuestionService.removeQuestion(new Question("Question", "Answer"));

        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> javaQuestionService.removeQuestion(new Question("Question", "Answer")));

    }

    //    Collection<Question> getAllQuestion();


    @ParameterizedTest
    @MethodSource("questions")
    public void getRandomQuestionTest(Set<Question> questions) {
        questions.forEach(javaQuestionService::addQuestion);

        assertThat(javaQuestionService.getRandomQuestion()).isIn(javaQuestionService.getAllQuestion());
    }

    public static Stream<Arguments> questions() {
        return Stream.of(
                Arguments.of(
                        Set.of( new Question("Qestion1", "Answer1"),
                                new Question("Qestion2", "Answer2"),
                                new Question("Qestion3", "Answer3"))));
    }


}
