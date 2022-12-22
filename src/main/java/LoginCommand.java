import javax.inject.Inject;
import java.util.Optional;

final class LoginCommand extends SingleArgCommand {
    private final Outputter outputter;
    private final Database database;
    private final UserCommandsRouter.Factory userCommandsRouterFactory;
    private final Optional<Database.Account> account;

    @Inject
    LoginCommand(
            Database database,
            Outputter outputter,
            UserCommandsRouter.Factory userCommandsRouterFactory,
            Optional<Database.Account> account
    ) {
        System.out.println("Creating a new " + this);
        this.database = database;
        this.outputter = outputter;
        this.userCommandsRouterFactory = userCommandsRouterFactory;
        this.account = account;
    }

    @Override
    public Result handleArg(String username) {
        if (account.isPresent()) {
            // Ignore "login <foo>" commands if we already have an account
            outputter.output("Please logout of " + account.get().username() + " before login of " + username);
            return Result.handled();
        }

        Database.Account account = database.getAccount(username);
        outputter.output(username + " is logged in with balance: " + account.balance());
        return Result.enterNestedCommandSet(
                userCommandsRouterFactory.create(account).router()
        );
    }
}
