package concurrency.synchronizedsample.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ATMTest {
    private ATM systemUnderTest;

    @BeforeEach
    void setUp() {
        systemUnderTest = new ATM();
    }

    // GIVEN an ATM with an account being detected
    // WHEN a valid debit transaction is executed
    // THEN the ATM requests debit transaction to the account and returns 200 result from the account
    @Test
    void shouldReturnResult200_WhenAValidDebitTransactionIsRequested() {
        // ARRANGE
        String expected = "transaction status: 200";
        BankAccount account = new BankAccount(BigDecimal.valueOf(100.00));
        BigDecimal amount = BigDecimal.valueOf(10.00);

        // ACT
        String actual = systemUnderTest.requestDebit(account, amount);

        // ASSERT
        assertEquals(expected, actual);
    }

    // GIVEN an ATM with an account being detected
    // WHEN an invalid debit transaction is executed
    // THEN the ATM requests debit transaction to the account and returns 400 result from the account
    @Test
    void shouldReturnResult400_WhenANonValidDebitTransactionIsRequested() {
        // ARRANGE
        String expected = "transaction status: 400";
        BankAccount account = new BankAccount(BigDecimal.valueOf(100.00));
        BigDecimal amount = BigDecimal.valueOf(110.00);

        // ACT
        String actual = systemUnderTest.requestDebit(account, amount);

        // ASSERT
        assertEquals(expected, actual);
    }
}