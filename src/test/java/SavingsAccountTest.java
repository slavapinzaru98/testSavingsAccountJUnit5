
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SavingsAccountTest {


    @Test
    void getSavingsBalanceWithValidDataTest() {
        SavingsAccount savingsAccountValidInput = new SavingsAccount("11111111", Input.POSITIVE_INPUT);
        SavingsAccount.annualInterestRate = 0.04;

        savingsAccountValidInput.calculateMonthlyInterest();
        double result = savingsAccountValidInput.getSavingsBalance();
        assertEquals(3010.0, result);
    }

    @Test
    void getSavingsBalanceWithInvalidDataTest() {
        SavingsAccount savingsAccountInvalidInput = new SavingsAccount("11111111", Input.NEGATIVE_INPUT);
        SavingsAccount.annualInterestRate = 0.04;

        savingsAccountInvalidInput.calculateMonthlyInterest();
        double result = savingsAccountInvalidInput.getSavingsBalance();
        try {
            if (result <= 0) {
                throw new Exception("result must be positive");
            }
        } catch (Exception exception) {
            assertEquals("result must be positive", exception.getMessage());
        }
    }

}