import javax.inject.Inject;

final class LoginCommand extends SingleArgCommand {
    private final Outputter outputter;
    private final Database database;

    @Inject
    LoginCommand(Database database, Outputter outputter) {
        System.out.println("Creating a new " + this);
        this.database = database;
        this.outputter = outputter;
    }

    @Override
    public String key() {
        return "login";
    }

    @Override
    public Status handleArg(String username) {
        Database.Account account = database.getAccount(username);
        outputter.output(username + " is logged in with balance: " + account.balance());
        return Status.HANDLED;
    }
}
