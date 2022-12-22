import javax.inject.Inject;
import java.util.List;

final class LogoutCommand implements Command {

    @Inject
    LogoutCommand() {
        System.out.println("Creating a new " + this);
    }

    @Override
    public Result handleInput(List<String> input) {
        return input.isEmpty() ? Result.inputCompleted() : Result.invalid();
    }
}
