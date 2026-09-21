public class Main {
    public static void main(String[] args) {
        Account a = new Account();
        Transaction t1 = new Transaction("01", 42);
        Transaction t2 = new Transaction("02", 52);
        Transaction t3 = new Transaction("03", 62);

        a.addTransaction(t1);
        a.addTransaction(t2);
        a.addTransaction(t3);

        Transaction[] history = a.getHistory();
        history[0].false_amount = 999999;
        history[1] = null;
        
        a.printHistory();
        System.out.println("-> false_amount in account: " +
                           t1.false_amount + " / " +
                           a.getHistory()[1].false_amount);
    }
}
