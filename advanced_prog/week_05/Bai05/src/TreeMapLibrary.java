import java.util.TreeMap;

public class TreeMapLibrary implements Library {
    private TreeMap<String, Book> store;

    public TreeMapLibrary() {
        this.store = new TreeMap<String, Book>();
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
