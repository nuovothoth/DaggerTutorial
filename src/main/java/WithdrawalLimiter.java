import javax.inject.Inject;
import java.math.BigDecimal;


@PerSession
final class WithdrawalLimiter {
    private BigDecimal remainingWithdrawalLimit;

    @Inject
    WithdrawalLimiter(@MaximumWithdrawal BigDecimal maximumWithdrawal) {
        this.remainingWithdrawalLimit = maximumWithdrawal;
    }

    void recordDeposit(BigDecimal amount) {
        remainingWithdrawalLimit = remainingWithdrawalLimit.add(amount);
    }

    void recordWithdrawal(BigDecimal amount) {
        remainingWithdrawalLimit = remainingWithdrawalLimit.subtract(amount);
    }

    BigDecimal remainingWithdrawalLimit() {
        return remainingWithdrawalLimit;
    }
}