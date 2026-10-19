public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread t = new Thread(worker);
        t.start();
        try {
            Thread.sleep(1000);
            worker.stop();
            t.join();
        } catch (InterruptedException e) {};
       
    }
}
