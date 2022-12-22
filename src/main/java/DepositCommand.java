import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

final class DepositCommand extends BigDecimalCommand {
    private final Database.Account account;
    private final Outputter outputter;

    @Inject
    DepositCommand(Database.Account account, Outputter outputter) {
        super(outputter);
        System.out.println("Creating a new " + this);
        this.account = account;
        this.outputter = outputter;
    }

    @Override
    public void handleAmount(BigDecimal amount) {
        account.deposit(amount);
        outputter.output(account.username() + " now has: " + account.balance());
    }
}
