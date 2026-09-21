public class Transaction {
    private String transactionId;
    private double amount;
    private String timestamp;
    public double false_amount = 888;

    private static int time = 1;

    public Transaction(String id, double amount) {
        this.transactionId = id;
        this.amount = amount;
        this.timestamp = "" + time;
        time++;
    }

    public Transaction(Transaction t) {
        this.transactionId = t.transactionId;
        this.amount = t.amount;
        this.timestamp = t.timestamp;
    }

    public String getId() { return this.transactionId; }
    public double getAmount() { return this.amount; }
    public String getTime() { return this.timestamp; }
}
