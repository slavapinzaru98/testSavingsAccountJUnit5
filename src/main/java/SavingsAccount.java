public class SavingsAccount {
    private String identifierField;
    static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(String identifierField, double savingsBalance) {
        this.identifierField = identifierField;
        this.savingsBalance = savingsBalance;
    }

    public void calculateMonthlyInterest() {
        if (savingsBalance > 0) {
            savingsBalance += (savingsBalance * annualInterestRate) / 12;
        }else {
            savingsBalance *= -1;
            savingsBalance += (savingsBalance * annualInterestRate) / 12;
        }
    }


    public static void transferFunds(double amountOfFunds, SavingsAccount savingsAccount1, SavingsAccount savingsAccount2) {
        if (savingsAccount1.savingsBalance > amountOfFunds) {
            savingsAccount1.savingsBalance = savingsAccount1.savingsBalance - amountOfFunds;
            savingsAccount2.savingsBalance = savingsAccount2.savingsBalance + amountOfFunds;
        } else System.out.println("not enough funds for transfer");
    }

    public static void modifyInterestRate(double modifyAnnualInterestRate) {
        SavingsAccount.annualInterestRate = modifyAnnualInterestRate;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount("11111111", 2000);
        SavingsAccount saver2 = new SavingsAccount("22222222", 3000);
        SavingsAccount.annualInterestRate = 0.04;

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.println(saver1.getSavingsBalance());
        System.out.println(saver2.getSavingsBalance());
        System.out.println();

        SavingsAccount.modifyInterestRate(0.05);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.println(saver1.getSavingsBalance());
        System.out.println(saver2.getSavingsBalance());
        System.out.println();

        System.out.println("Before transfer");
        System.out.println(saver1.getSavingsBalance());
        System.out.println(saver2.getSavingsBalance());
        System.out.println();

        SavingsAccount.transferFunds(700, saver1, saver2);
        System.out.println("After transfer");
        System.out.println(saver1.getSavingsBalance());
        System.out.println(saver2.getSavingsBalance());
        System.out.println();

    }
}
