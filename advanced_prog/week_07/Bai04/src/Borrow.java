public class Borrow implements Runnable {
    private BookStore store;
    private String[] books = {"Apocalypse", "Don Quixote", "Harry Potter"};

    public Borrow(BookStore store) {
        this.store = store;
    }

    @Override
    public void run() {
        int i = 0;
        int id = 0;
        while (true) {
            id = 2 - (i % 3);
            store.borrow(books[id], 1);
            i++;
            try { Thread.sleep(2800); }
            catch (InterruptedException e) {}
        }
    }
}
