import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayDeque;
import java.util.Deque;

@Singleton
final class CommandProcessor {
    private final Deque<CommandRouter> commandRouterStack = new ArrayDeque<>();

    @Inject
    CommandProcessor(CommandRouter firstCommandRouter) {
        commandRouterStack.push(firstCommandRouter);
    }

    Command.Status process(String input) {
        /*Command.Result result = commandRouterStack.peek().route(input);
        if (result.status().equals(Status.INPUT_COMPLETED)) {
            commandRouterStack.pop();
            return commandRouterStack.isEmpty()
                    ? Command.Status.INPUT_COMPLETED
                    : Command.Status.HANDLED;
        }

        result.nestedCommandRouter().ifPresent(commandRouterStack::push);*/
        Command.Status status = commandRouterStack.peek().route(input);
        if (status.equals(Command.Status.INPUT_COMPLETED)) {
            commandRouterStack.pop();
            return commandRouterStack.isEmpty()
                    ? Command.Status.INPUT_COMPLETED
                    : Command.Status.HANDLED;
        }

        return status;
//        return Command.Status.HANDLED;
    }
}
