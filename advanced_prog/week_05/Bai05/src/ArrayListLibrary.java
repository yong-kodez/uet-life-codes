import java.util.ArrayList;

public class ArrayListLibrary implements Library {
    private ArrayList<Book> store;

    public ArrayListLibrary() {
        this.store = new ArrayList<Book>();
    } 

    @Override
    public boolean addBook(Book newBook) {
        for (Book b : store) {
            if (newBook.getId().equals(b.getId())) {
                return false;
            }
        }
        store.add(newBook);
        return true;
    }

    @Override
    public Book searchBook(String id) {
        for (Book b : store) {
            if (id.equals(b.getId()))
                return b;
        }
        return null;
    }

    @Override
    public Book removeBook(String id) {
        Book book = this.searchBook(id);
        if (store.remove(book)) return book;
        return null;
        // if (book != null) {
        //     store.remove(book);
        //     return true;
        // }
        // return false;
    }

    @Override
    public void printStore() {
        for (Book b : store) {
            System.out.println(b.getId() + " - " + b.getTitle() + " - "
                               + b.getAuthor() + " - " + b.getYear());
        }
    }

    @Override
    public String getType() {
        return "ArrayListLibrary";
    }
}
