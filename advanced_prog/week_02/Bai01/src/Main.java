public class Main {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("14901337", "tony");
        double[] tests = {1, -233.13, 433.15, -230, 500, 400};
        String[] actions = {"w", "d", "d", "w", "w", "w"};

        for (int i = 0; i < tests.length; i++) {
            double n = tests[i];
            if (actions[i] == "w") witHandler(a1.withdraw(n), n);
            else depHandler(a1.deposit(n), n);
            System.out.println(" -> Current balance: " + a1.getBalance());
        }
        // witHandler(a1.withdraw(1), 1);
        // depHandler(a1.deposit(-233.13), -233.13);
        // depHandler(a1.deposit(433.13), 433.13);
        // witHandler(a1.withdraw(-230), -230);
        // witHandler(a1.withdraw(500), 500);
        // witHandler(a1.withdraw(300), 300);
    }

    public static void depHandler(boolean var, double amount) {
        System.out.println("* Depositing " + amount);
        if (var) System.out.println("  + Deposit success");
        else System.out.println("  [!] Deposit failed: amount must be positive");
    }

    public static void witHandler(boolean var, double amount) {
        System.out.println("* Withdrawing " + amount);
        if (var) System.out.println("  - Withdraw success");
        else {
            String fmt = "  [!] Withdraw failed: amount ";

            if (amount < 0) fmt += "must be positive";
            else fmt += "over balance";

            System.out.println(fmt);
        }
    }
}
