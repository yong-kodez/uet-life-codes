public class ReadTask implements Runnable {
    private BookStore store;
    private String title;

    public ReadTask(BookStore store, String title) {
        this.store = store;
        this.title = title;
    }

    @Override
    public void run() {
        while (true) {
            store.getStock(title);
            try { Thread.sleep(3000); }
            catch (InterruptedException e) {}
        }
    }
}
