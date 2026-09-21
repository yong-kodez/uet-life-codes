public class Account {
    private String accountId;
    private double balance;
    private Transaction[] history = new Transaction[0];

    public Transaction[] copyNew(Transaction[] ts, int len) {
        int ini_len = ts.length;
        Transaction[] his = new Transaction[len];
        for (int i = 0; i < ini_len; i++) {
            his[i] = new Transaction(ts[i]);
        }
        return his;
    }

    public void addTransaction(Transaction t) {
        Transaction[] his = copyNew(history, history.length + 1);
        his[history.length] = t;
        history = his;
    }

    public void printHistory() {
        System.out.println("ID\tAMOUNT\tTIMESTAMP");
        for (Transaction t : history) {
            System.out.println(t.getId() + "\t" +
                               t.getAmount() + "\t" +
                               t.getTime());
        }
    } 

    public String getId() { return this.accountId; }
    public double getBalance() { return this.balance; }
    public Transaction[] getHistory() {
        return copyNew(history, history.length);
    }
}
