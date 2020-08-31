package exam.paperContext.application;

import lombok.Data;

@Data
public class UpdateBlankQuizCommand {
    private String question;
    private String referenceAnswer;
    private int score;
}
