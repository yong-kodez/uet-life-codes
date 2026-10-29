public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task("Thread 1", 200));
        Thread thread2 = new Thread(new Task("Thread 2", 1000));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("[!] InterruptedException");
        }
        System.out.println("All task done");
    }
}
