package exam.paperContext.domain.model.blankQuiz;

import exam.paperContext.shared.Entity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BlankQuiz implements Entity<BlankQuiz> {

    private BlankQuizId blankQuizId;
    private String question;
    private String referenceAnswer;
    private int score;
    private String teacherId;
    private LocalDateTime createTime;

    @Override
    public boolean sameIdentityAs(BlankQuiz other) {
        return blankQuizId.sameValueAs(other.blankQuizId);
    }

    private BlankQuiz(BlankQuizId blankQuizId, String question, String referenceAnswer, int score, String teacherId) {
        this.blankQuizId = blankQuizId;
        this.question = question;
        this.referenceAnswer = referenceAnswer;
        this.score = score;
        this.teacherId = teacherId;
        this.createTime = LocalDateTime.now();
    }

    public static BlankQuiz create(BlankQuizId blankQuizId, String question, String referenceAnswer, int score, String teacherId) {
        validateScore(score);
        return new BlankQuiz(blankQuizId, question, referenceAnswer, score, teacherId);
    }

    private static void validateScore(int score) {
        if (score < 1 || score > 96) {
            throw new IllegalBlankQuizScoreException(score);
        }
    }

    public BlankQuiz update(String question, String referenceAnswer, int score) {
        validateScore(score);
        this.question = question;
        this.referenceAnswer = referenceAnswer;
        this.score = score;
        return this;
    }

}
