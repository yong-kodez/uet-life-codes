public class Worker implements Runnable {
    // Từ khóa volatile đảm bảo mọi thao tác ghi/đọc vào biến tương ứng
    // trực tiếp vào bộ nhớ chính, chứ không để các luồng tự đọc từ bản sao
    // trong cache của chúng
    private volatile boolean running;

    public Worker() {
        this.running = true;
    }
    
    public void stop() {
        this.running = false;
    }

    @Override
    public void run() {
        // Việc in ra bằng println có khối 'synchronized' nên mỗi lần
        // in ra bộ nhớ của luồng được đồng bộ lại với bộ nhớ chính.
        // Khiến dừng bằng stop() có thể không cần 'volatile'
        System.out.println("Working...");
        while (running) {
            // try { Thread.sleep(100); }
            // catch (InterruptedException e) {}
        }
    }
    
}
