import javax.inject.Inject;

final class LoginCommand extends SingleArgCommand {
    private final Outputter outputter;
    private final Database database;
    private final UserCommandsRouter.Factory userCommandsRouterFactory;

    @Inject
    LoginCommand(
            Database database,
            Outputter outputter,
            UserCommandsRouter.Factory userCommandsRouterFactory
    ) {
        System.out.println("Creating a new " + this);
        this.database = database;
        this.outputter = outputter;
        this.userCommandsRouterFactory = userCommandsRouterFactory;
    }

    @Override
    public Result handleArg(String username) {
        Database.Account account = database.getAccount(username);
        outputter.output(username + " is logged in with balance: " + account.balance());
        return Result.enterNestedCommandSet(
                userCommandsRouterFactory.create(account).router()
        );
    }
}
