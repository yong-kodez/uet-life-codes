public class BankAccount {
    private int balance;

    public BankAccount(int amount) {
        this.balance = amount;
    }

    public synchronized void deposit(int amount) { this.balance += amount; }
    public synchronized void withdraw(int amount) { this.balance -= amount; }
    public int getBalance() { return this.balance; }
}
