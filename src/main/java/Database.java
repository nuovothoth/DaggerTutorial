import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private final Map<String, Account> accounts = new HashMap<>();

    @Inject
    Database() {
        System.out.println("Creating a new " + this);
    }

    Account getAccount(String username) {
        return accounts.computeIfAbsent(username, Account::new);
    }

    static final class Account {
        private final String username;
        private BigDecimal balance = BigDecimal.ZERO;

        Account(String username) {
            this.username = username;
        }

        void deposit(BigDecimal amount) {
            balance = balance.add(amount);
        }

        String username() {
            return username;
        }

        BigDecimal balance() {
            return balance;
        }
    }
}
