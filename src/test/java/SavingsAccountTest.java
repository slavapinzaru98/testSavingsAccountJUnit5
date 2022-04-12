
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {


    @Test
    void validDataInput(){
        SavingsAccount savingsAccountValidInput = new SavingsAccount("11111111", 3000);
        SavingsAccount.annualInterestRate = 0.04;

        savingsAccountValidInput.calculateMonthlyInterest();
        double result = savingsAccountValidInput.getSavingsBalance();
        assertEquals(3010.0,result);
    }

    @Test
    void invalidDataInput(){
        SavingsAccount savingsAccountInvalidInput = new SavingsAccount("11111111", -3000);
        SavingsAccount.annualInterestRate = 0.04;

        savingsAccountInvalidInput.calculateMonthlyInterest();
        double result = savingsAccountInvalidInput.getSavingsBalance();
        assertEquals(3010.0,result);
    }

   }