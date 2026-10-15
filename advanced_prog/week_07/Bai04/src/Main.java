public class Main {
    public static void main(String[] args) {
        BookStore store = new BookStore();
        store.addBook("Apocalypse", 5);
        store.addBook("Don Quixote", 7);
        store.addBook("Harry Potter", 1);

        Runnable readTask = () -> {
            for (int i = 0; i < 10; i++)
                store.getStock()
        }
    } 
}
