// Base class: BankAccount
class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + ". New balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void displayBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest applied: $" + interest + ". New balance: $" + balance);
    }

    public void displayAccountType() {
        System.out.println("This is a Savings Account.");
    }
}

// Subclass: CheckingAccount
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > withdrawalLimit) {
            System.out.println("Withdrawal failed! Exceeds withdrawal limit of $" + withdrawalLimit);
        } else {
            super.withdraw(amount);
        }
    }

    public void displayAccountType() {
        System.out.println("This is a Checking Account.");
    }
}

// Subclass: FixedDepositAccount
class FixedDepositAccount extends BankAccount {
    private int maturityPeriod; // in months

    public FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawal not allowed until maturity period of " + maturityPeriod + " months is over.");
    }

    public void displayAccountType() {
        System.out.println("This is a Fixed Deposit Account.");
    }
}

// Main class to test the bank account types
public class BankSystem {
    public static void main(String[] args) {
        // Savings Account
        SavingsAccount savings = new SavingsAccount("SA12345", 5000, 3.5);
        savings.displayAccountType();
        savings.displayBalance();
        savings.applyInterest();
        savings.deposit(1000);
        savings.withdraw(2000);
        System.out.println();

        // Checking Account
        CheckingAccount checking = new CheckingAccount("CA67890", 3000, 1000);
        checking.displayAccountType();
        checking.displayBalance();
        checking.deposit(500);
        checking.withdraw(1500);
        checking.withdraw(800);
        System.out.println();

        // Fixed Deposit Account
        FixedDepositAccount fixedDeposit = new FixedDepositAccount("FDA54321", 10000, 12);
        fixedDeposit.displayAccountType();
        fixedDeposit.displayBalance();
        fixedDeposit.withdraw(5000);
    }
}
