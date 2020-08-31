package exam.paperContext.domain.model.blankQuiz;

import java.util.List;
import java.util.Set;

public interface BlankQuizRepository {

    BlankQuiz find(BlankQuizId blankQuizId);

    List<BlankQuiz> getByPage(int page);

    List<BlankQuiz> getByIds(Set<BlankQuizId> blankQuizIds);

    void save(BlankQuiz blankQuiz);

    void delete(BlankQuiz blankQuiz);
}
