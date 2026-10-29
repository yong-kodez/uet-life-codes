public class Restock implements Runnable {
    private BookStore store;
    private String[] books = {"Apocalypse", "Don Quixote", "Harry Potter"};

    public Restock(BookStore store) {
        this.store = store;
    }

    @Override
    public void run() {
        int i = 0;
        int id = 0;
        while (true) {
            id = i % 3;
            store.restock(books[id], 1);
            i++;
            try { Thread.sleep(2500); }
            catch (InterruptedException e) {}
        }
    }
}
