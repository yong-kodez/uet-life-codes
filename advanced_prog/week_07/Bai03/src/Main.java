public class Main {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount(2000);
        Runnable ra = () -> {
            for (int i = 0; i < 1000; i++)
                ba.deposit(100);
        };
        Runnable rb = () -> {
            for (int i = 0; i < 1000; i++)
                ba.withdraw(100);
        };

        Thread t1 = new Thread(ra);
        Thread t2 = new Thread(rb);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) { System.err.println("[!] Interrupted"); }

        System.out.println("-> Final balance: " + ba.getBalance());
    }
}
