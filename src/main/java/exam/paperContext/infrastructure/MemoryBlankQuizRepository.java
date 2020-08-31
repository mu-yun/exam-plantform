package exam.paperContext.infrastructure;

import exam.paperContext.domain.model.blankQuiz.BlankQuiz;
import exam.paperContext.domain.model.blankQuiz.BlankQuizId;
import exam.paperContext.domain.model.blankQuiz.BlankQuizRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

public class MemoryBlankQuizRepository implements BlankQuizRepository {

    public static final int PAGE_SIZE = 10;

    private static final List<BlankQuiz> BLANK_QUIZZES = new ArrayList<>();

    @Override
    public BlankQuiz find(BlankQuizId blankQuizId) {
        return BLANK_QUIZZES.stream()
                .filter(blankQuiz -> blankQuiz.getBlankQuizId().equals(blankQuizId))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<BlankQuiz> getByPage(int page) {
        return BLANK_QUIZZES.stream()
                .skip(PAGE_SIZE * (page - 1))
                .limit(PAGE_SIZE)
                .collect(Collectors.toList());
    }

    @Override
    public List<BlankQuiz> getByIds(Set<BlankQuizId> blankQuizIds) {
        return BLANK_QUIZZES.stream()
                .filter(blankQuiz -> blankQuizIds.contains(blankQuiz.getBlankQuizId()))
                .collect(Collectors.toList());
    }

    @Override
    public void save(BlankQuiz blankQuiz) {
        BLANK_QUIZZES.add(blankQuiz);
    }

    @Override
    public void delete(BlankQuiz blankQuiz) {
        BLANK_QUIZZES.remove(blankQuiz);
    }
}
