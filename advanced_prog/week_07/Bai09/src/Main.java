public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread[] threads = new Thread[4];

        for (int i = 0; i < 4; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++)
                    counter.increment();
            });
        }

        for (Thread t : threads) t.start();
        for (Thread t : threads) {
            try { t.join(); }
            catch (InterruptedException e) {};
        }

        System.out.println("Final value " + counter.getValue()); 

    }
}
