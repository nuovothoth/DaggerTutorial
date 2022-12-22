import javax.inject.Inject;
import java.math.BigDecimal;

final class WithdrawCommand extends BigDecimalCommand {
    private final Database.Account account;
    private final Outputter outputter;
    private final BigDecimal minimumBalance;
    private final BigDecimal maximumWithdrawal;

    @Inject
    WithdrawCommand(
            Outputter outputter,
            Database.Account account,
            @MinimumBalance BigDecimal minimumBalance,
            @MaximumWithdrawal BigDecimal maximumWithdrawal
    ) {
        super(outputter);
        System.out.println("Creating a new " + this);
        this.account = account;
        this.outputter = outputter;
        this.minimumBalance = minimumBalance;
        this.maximumWithdrawal = maximumWithdrawal;
    }

    @Override
    public void handleAmount(BigDecimal amount) {
        if (amount.compareTo(maximumWithdrawal) > 0) {
            // output error
            return;
        }


        BigDecimal newBalance = account.balance().subtract(amount);
        if (newBalance.compareTo(minimumBalance)< 0) {
            // output error
            return;
        } else {
            account.withdraw(amount);
            outputter.output("your new balance is: " + account.balance());
        }
    }
}