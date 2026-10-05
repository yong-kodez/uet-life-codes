import java.util.ArrayList;

public class ArrayListLibrary implements Library {
    private ArrayList<Book> store;

    public ArrayListLibrary() {
        this.store = new ArrayList<Book>();
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
