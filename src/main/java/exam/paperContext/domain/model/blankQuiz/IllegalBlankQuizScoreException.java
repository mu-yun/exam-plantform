package exam.paperContext.domain.model.blankQuiz;

public class IllegalBlankQuizScoreException extends IllegalArgumentException {

    public IllegalBlankQuizScoreException(int score) {
        super("IllegalScoreException: exception score must less than 97 and greater than 0, actual:" + score);
    }
}
