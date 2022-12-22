import javax.inject.Inject;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


final class CommandRouter {
    private final Map<String, Command> commands;

    @Inject
    CommandRouter(Map<String, Command> commands) {
//        commands.put(command.key(), command);
        this.commands = commands;
    }

    Command.Result route(String input) {
        List<String> splitInput = split(input);

        if (splitInput.isEmpty()) {
            return invalidCommand(input);
        }

        String commandKey = splitInput.get(0);
        Command command = commands.get(commandKey);
        if (command == null) {
            return invalidCommand(input);
        }

        Command.Result result = command.handleInput(splitInput.subList(1, splitInput.size()));
        if (result.status() == Command.Status.INVALID) {
            System.out.println(commandKey + ": invalid arguments");
        }
        return result;
    }

    private Command.Result invalidCommand(String input) {
        System.out.println(String.format("couldn't understand \"%s\". please try again.", input));
        return Command.Result.invalid();
    }

    private static List<String> split(String string) {
        return List.of(string.split(" "));
    }
}
