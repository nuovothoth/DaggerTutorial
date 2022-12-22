import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

final class DepositCommand extends BigDecimalCommand {
    private final Outputter outputter;
    private final Database.Account account;
    private final WithdrawalLimiter withdrawalLimiter;

    @Inject
    DepositCommand(Outputter outputter, Database.Account account, WithdrawalLimiter withdrawalLimiter) {
        super(outputter);
        System.out.println("Creating a new " + this);
        this.outputter = outputter;
        this.account = account;
        this.withdrawalLimiter = withdrawalLimiter;
    }

    @Override
    protected void handleAmount(BigDecimal amount) {
        account.deposit(amount);
        withdrawalLimiter.recordDeposit(amount);
        outputter.output("your new balance is: " + account.balance());
    }
}
