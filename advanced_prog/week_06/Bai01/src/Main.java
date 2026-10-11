public class Main {
    public static void main(String[] args) {
        Runnable r1 = () -> {
            AppConfig app1 = AppConfig.getInstance();
            System.out.println("- Thread 1: " + app1.hashCode());
        };        

        Runnable r2 = () -> {
            AppConfig app2 = AppConfig.getInstance();
            System.out.println("- Thread 2: " + app2.hashCode());
        };        

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
