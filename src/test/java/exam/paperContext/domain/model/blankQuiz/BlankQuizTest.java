package exam.paperContext.domain.model.blankQuiz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;


class BlankQuizTest {

    @Test
    void should_create_blank_quiz() {
        BlankQuizId blankQuizId = new BlankQuizId("blank-quiz-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1");
        String teacherId = "teacher-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1";
        String question = "1+1=?";
        String referenceAnswer = "2";
        int score = 1;

        BlankQuiz blankQuiz = BlankQuiz.create(blankQuizId, question, referenceAnswer, score, teacherId);

        assertThat(blankQuiz, notNullValue());
        assertThat(blankQuiz.getBlankQuizId(), is(blankQuizId));
        assertThat(blankQuiz.getCreateTime(), instanceOf(LocalDateTime.class));
        assertThat(blankQuiz.getCreateTime(), notNullValue());
        assertThat(blankQuiz.getQuestion(), is(question));
        assertThat(blankQuiz.getReferenceAnswer(), is(referenceAnswer));
        assertThat(blankQuiz.getScore(), is(score));
    }

    @Test
    void score_should_greater_than_0() {
        Assertions.assertThrows(IllegalBlankQuizScoreException.class, () -> {
            BlankQuizId blankQuizId = new BlankQuizId("blank-quiz-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1");
            String teacherId = "teacher-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1";
            String question = "1+1=?";
            String referenceAnswer = "2";
            int score = 0;

            BlankQuiz blankQuiz = BlankQuiz.create(blankQuizId, question, referenceAnswer, score, teacherId);
        });
    }

    @Test
    void score_should_less_than_97() {
        Assertions.assertThrows(IllegalBlankQuizScoreException.class, () -> {
            BlankQuizId blankQuizId = new BlankQuizId("blank-quiz-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1");
            String teacherId = "teacher-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1";
            String question = "1+1=?";
            String referenceAnswer = "2";
            int score = 97;

            BlankQuiz blankQuiz = BlankQuiz.create(blankQuizId, question, referenceAnswer, score, teacherId);
        });
    }

    @Test
    void should_update_blank_quiz() {
        BlankQuizId blankQuizId = new BlankQuizId("blank-quiz-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1");
        String teacherId = "teacher-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1";
        String question = "1+1=?";
        String referenceAnswer = "2";
        int score = 1;

        BlankQuiz blankQuiz = BlankQuiz.create(blankQuizId, question, referenceAnswer, score, teacherId);

        String newQuestion = "2+2=?";
        String newReferenceAnswer = "4";
        int newScore = 5;
        blankQuiz.update(newQuestion, newReferenceAnswer, newScore);
        assertThat(blankQuiz, notNullValue());
        assertThat(blankQuiz.getBlankQuizId(), is(blankQuizId));
        assertThat(blankQuiz.getCreateTime(), instanceOf(LocalDateTime.class));
        assertThat(blankQuiz.getCreateTime(), notNullValue());
        assertThat(blankQuiz.getQuestion(), is(newQuestion));
        assertThat(blankQuiz.getReferenceAnswer(), is(newReferenceAnswer));
        assertThat(blankQuiz.getScore(), is(newScore));
    }
}