package concurrency.synchronizedsample.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {
    private BankAccount systemUnderTest;

    @BeforeEach
    void setUp() {
        systemUnderTest = new BankAccount(BigDecimal.valueOf(100.00));
    }

    // GIVEN a bank account
    // WHEN a customer withdraws amount lower than balance
    // THEN the bank account should allow to do this and process balance accordingly
    @Test
    void shouldReduceAccountBalance_WhenAValidDebitAmountIsDebited() {
        // ARRANGE
        BigDecimal expected = BigDecimal.valueOf(90.00);

        // ACT
        systemUnderTest.debit(BigDecimal.valueOf(10.00));

        // ASSERT
        assertEquals(expected, systemUnderTest.getBalance());
    }

    // GIVEN a bank account
    // WHEN a customer withdraws all
    // THEN the bank account should allow to do this and process balance accordingly
    @Test
    void shouldHaveBalanceZero_WhenAllBalanceIsDebited() {
        // ARRANGE
        BigDecimal expected = BigDecimal.valueOf(0.00);

        // ACT
        systemUnderTest.debit(BigDecimal.valueOf(100.00));

        // ASSERT
        assertEquals(expected, systemUnderTest.getBalance());
    }

    // GIVEN a bank account
    // WHEN a customer withdraws bigger amount than balanca
    // THEN the bank account should reject this and throws a runtime error
    @Test
    void shouldThrowRuntimeError_WhenNonValidDebitAmountIsDebited() {
        // ARRANGE
        String expected = "Amount too big. Cannot proceed.";

        // ACT
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> systemUnderTest.debit(BigDecimal.valueOf(110.00)));

        // ASSERT
        assertEquals(expected, runtimeException.getMessage());
    }

}