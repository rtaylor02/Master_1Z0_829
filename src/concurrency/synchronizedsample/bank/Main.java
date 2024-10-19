package concurrency.synchronizedsample.bank;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(BigDecimal.valueOf(100.00));
        ATM atm1 = new ATM();
        ATM atm2 = new ATM();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> atm1.requestDebit(bankAccount, BigDecimal.valueOf(50.00)));
        executorService.submit(() -> atm2.requestDebit(bankAccount, BigDecimal.valueOf(150.00)));

        executorService.shutdown();
    }
}

class BankAccount {
    private BigDecimal balance;

    public BankAccount(BigDecimal bigDecimal) {
        this.balance = BigDecimal.valueOf(bigDecimal.doubleValue());
    }

    public void debit(BigDecimal amount) {
        if (this.balance.compareTo(amount) >= 0) {
            synchronized (this) {
                this.balance = this.balance.subtract(amount);
            }
            System.out.println("Balance now: " + this.balance);
        } else {
            System.out.println("Invalid amount..");
            throw new RuntimeException("Amount too big. Cannot proceed.");
        }
    }

    public BigDecimal getBalance() {
        return this.balance;
    }
}

class ATM {

    public String requestDebit(BankAccount account, BigDecimal amount) {
        System.out.println(Thread.currentThread().getName() + " is withdrawing...");
        try {
            account.debit(amount);
            return "transaction status: 200";
        } catch (RuntimeException re) {
            if (re.getMessage().equals("Amount too big. Cannot proceed.")) {
                return "transaction status: 400";
            } else {
                return "Unknown error";
            }
        }
    }
}
