import dagger.Component;

import javax.inject.Singleton;
import java.util.Scanner;

public class CommandLineAtm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandProcessor commandProcessor =
                DaggerCommandLineAtm_CommandProcessorFactory.create().processor();

        while (scanner.hasNextLine()) {
            commandProcessor.process(scanner.nextLine());
        }
    }

    @Singleton
    @Component(modules = {HelloWorldModule.class, LoginCommandModule.class, UserCommandsModule.class, SystemOutModule.class})
    interface CommandProcessorFactory {
        CommandProcessor processor();
    }
}
