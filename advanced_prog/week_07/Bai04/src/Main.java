public class Main {
    public static void main(String[] args) {
        BookStore store = new BookStore();
        store.restock("Apocalypse", 5);
        store.restock("Don Quixote", 7);
        store.restock("Harry Potter", 1);

        Thread adder = new Thread(new Restock(store));
        Thread borrower = new Thread(new Borrow(store));
        Thread read01 = new Thread(new ReadTask(store, "Apocalypse"));
        Thread read02 = new Thread(new ReadTask(store, "Don Quixote"));
        Thread read03 = new Thread(new ReadTask(store, "Harry Potter"));

        adder.start();
        borrower.start();
        read01.start();
        read02.start();
        read03.start();
    } 
}
