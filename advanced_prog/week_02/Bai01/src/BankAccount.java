public class BankAccount {
    private String accountNumber;
    private double balance;
    private String ownerName;

    public void BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0;
    }  

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("- [Deposit]: Failed! Amount must be positive");
            return false;
        }
        this.balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        double balance = this.balance;
        if ((amount > balance) || (amount <= 0)) return false;
        this.balance -= amount;
        return true;
    }

    public double getBalance() {
        return this.balance;
    }
}
