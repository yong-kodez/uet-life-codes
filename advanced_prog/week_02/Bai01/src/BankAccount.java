public class BankAccount {
    private String accountNumber;
    private double balance;
    private String ownerName;

    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0;
    }  

    public boolean deposit(double amount) {
        if (amount <= 0) return false;
        this.balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if ((amount > this.balance) || (amount <= 0)) return false;
        this.balance -= amount;
        return true;
    }

    public double getBalance() {
        return this.balance;
    }
}
