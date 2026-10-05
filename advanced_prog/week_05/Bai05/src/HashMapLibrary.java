import java.util.HashMap;

public class HashMapLibrary implements Library {
    private HashMap<String, Book> store;

    public HashMapLibrary() {
        this.store = new HashMap<String, Book>();
    } 

    @Override
    void addBook(Book b);

    @Override
    Book searchBook(String id);

    @Override
    void removeBook(Book b);

    @Override
    void printStore();
}
