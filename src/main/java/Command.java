import java.util.List;
import java.util.Optional;

public interface Command {
    String key();

    Status handleInput(List<String> input);

    class Result {
        private final Status status;
        private final Optional<CommandRouter> nestedCommandRouter;

        Result(Status status, Optional<CommandRouter> nestedCommandRouter) {
            this.status = status;
            this.nestedCommandRouter = nestedCommandRouter;
        }

        static Result enterNestedCommandSet(CommandRouter nestedCommandRouter) {
            return new Result(Status.HANDLED, Optional.of(nestedCommandRouter));
        }
    }

    enum Status {
        INVALID,
        HANDLED,
        INPUT_COMPLETED
    }
}
