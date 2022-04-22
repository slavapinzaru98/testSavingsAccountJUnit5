
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class SavingsAccountTest {


    @Test
    void calculateMonthlyInterestWithValidDataTest() {
        SavingsAccount savingsAccountValidInput = new SavingsAccount("11111111", Input.POSITIVE_INPUT);
        SavingsAccount.annualInterestRate = 0.04;

        savingsAccountValidInput.calculateMonthlyInterest();
        double result = savingsAccountValidInput.getSavingsBalance();
        assertEquals(3010.0, result);
    }

    @Test
    void calculateMonthlyInterestWithInvalidDataTest() {
        SavingsAccount savingsAccountInvalidInput = new SavingsAccount("11111111", Input.NEGATIVE_INPUT);
        SavingsAccount.annualInterestRate = 0.04;

        savingsAccountInvalidInput.calculateMonthlyInterest();
        double result = savingsAccountInvalidInput.getSavingsBalance();
        assertEquals(Input.NEGATIVE_INPUT, result);
    }

    @Test
    void transferFundsWithValidDataTest() {
        SavingsAccount saver1 = new SavingsAccount("11111111", 2000);
        SavingsAccount saver2 = new SavingsAccount("22222222", 3000);
        SavingsAccount.transferFunds(Input.ENOUGH_FUNDS_FOR_TRANSFER, saver1, saver2);
        assertEquals(saver1.getSavingsBalance(), 1300);
        assertEquals(saver2.getSavingsBalance(), 3700);
    }

    @Test
    void transferFundsWithInvalidDataTest() {
        SavingsAccount saver1 = new SavingsAccount("11111111", 2000);
        SavingsAccount saver2 = new SavingsAccount("22222222", 3000);
        SavingsAccount.transferFunds(Input.NOT_ENOUGH_FUNDS_FOR_TRANSFER, saver1, saver2);
        assertEquals(saver1.getSavingsBalance(), 2000);
        assertEquals(saver2.getSavingsBalance(), 3000);
    }

}