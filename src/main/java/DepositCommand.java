import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

final class DepositCommand implements Command {
    private Database database;
    private Outputter outputter;

    @Inject
    DepositCommand(Database database, Outputter outputter) {
        System.out.println("Creating a new " + this);
        this.database = database;
        this.outputter = outputter;
    }

    @Override
    public String key() {
        return "deposit";
    }

    @Override
    public Status handleInput(List<String> input) {
        if (input.size() != 2) {
            return Status.INVALID;
        }

        Database.Account account = database.getAccount(input.get(0));
        account.deposit(new BigDecimal(input.get(1)));
        outputter.output(account.username() + " now has: " + account.balance());

        return Status.HANDLED;
    }
}
