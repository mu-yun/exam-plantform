package exam.paperContext.domain.model.blankQuiz;

import exam.paperContext.shared.ValueObject;

import java.util.Objects;

public class BlankQuizId implements ValueObject<BlankQuizId> {

    private String id;

    public static BlankQuizId nextId() {
        //TODO Generate ID
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlankQuizId that = (BlankQuizId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean sameValueAs(BlankQuizId other) {
        return equals(other);
    }
}
