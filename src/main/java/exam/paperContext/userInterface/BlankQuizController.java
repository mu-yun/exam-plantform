package exam.paperContext.userInterface;

import exam.paperContext.application.BlankQuizApplicationService;
import exam.paperContext.application.CreateBlankQuizCommand;
import exam.paperContext.application.UpdateBlankQuizCommand;
import exam.paperContext.domain.model.blankQuiz.BlankQuiz;
import exam.paperContext.domain.model.blankQuiz.BlankQuizId;
import exam.paperContext.domain.model.blankQuiz.BlankQuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("blank-quiz")
@RequiredArgsConstructor
public class BlankQuizController {

    private final BlankQuizRepository blankQuizRepository;
    private final BlankQuizApplicationService blankQuizApplicationService;

    @PostMapping("/")
    public void create(@RequestBody CreateBlankQuizCommand command) {
        blankQuizApplicationService.create(command);
    }

    @PutMapping("/{blankQuizId}")
    public void update(@PathVariable BlankQuizId blankQuizId, @RequestBody UpdateBlankQuizCommand command) {
        blankQuizApplicationService.update(blankQuizId, command);
    }

    @GetMapping("/{blankQuizId}")
    public BlankQuiz get(@PathVariable BlankQuizId blankQuizId) {
        return blankQuizRepository.find(blankQuizId);
    }

    @DeleteMapping("/{blankQuizId}")
    public void delete(@PathVariable BlankQuizId blankQuizId) {
        blankQuizApplicationService.delete(blankQuizId);
    }
}
