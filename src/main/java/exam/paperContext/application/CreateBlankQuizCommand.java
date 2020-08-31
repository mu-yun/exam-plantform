package exam.paperContext.application;

import lombok.Data;

@Data
public class CreateBlankQuizCommand {

    private String question;
    private String referenceAnswer;
    private int score;
    private String teacherId;

}
