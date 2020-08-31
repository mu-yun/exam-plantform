package exam.paperContext.application;

import exam.paperContext.domain.model.blankQuiz.BlankQuiz;
import exam.paperContext.domain.model.blankQuiz.BlankQuizId;
import exam.paperContext.domain.model.blankQuiz.BlankQuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlankQuizApplicationService {

    private final BlankQuizRepository blankQuizRepository;

    public void create(CreateBlankQuizCommand command) {
        BlankQuizId blankQuizId = BlankQuizId.nextId();
        final String teacherId = command.getTeacherId();
        final String question = command.getQuestion();
        final String referenceAnswer = command.getReferenceAnswer();
        final int score = command.getScore();
        blankQuizRepository.save(BlankQuiz.create(blankQuizId, question, referenceAnswer, score, teacherId));
    }

    public void update(BlankQuizId blankQuizId, UpdateBlankQuizCommand command) {
        BlankQuiz blankQuiz = blankQuizRepository.find(blankQuizId);
        blankQuiz.update(command.getQuestion(), command.getReferenceAnswer(), command.getScore());
    }

    public void delete(BlankQuizId blankQuizId) {
        BlankQuiz blankQuiz = blankQuizRepository.find(blankQuizId);
        blankQuizRepository.delete(blankQuiz);
    }
}
