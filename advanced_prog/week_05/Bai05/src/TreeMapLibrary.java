import java.util.TreeMap;

public class TreeMapLibrary implements Library {
    private TreeMap<String, Book> store;

    public TreeMapLibrary() {
        this.store = new TreeMap<String, Book>();
    } 

    @Override
    public boolean addBook(Book newBook) {
        if (!store.containsKey(newBook.getId())) {
            store.put(newBook.getId(), newBook);
            return true;
        }
        return false;
    }

    @Override
    public Book searchBook(String id) {
        if (store.containsKey(id)) return store.get(id);
        return null;
    }

    @Override
    public Book removeBook(String id) {
        return store.remove(id);
    }

    @Override
    public void printStore() {
        for (Book b : store.values()) {
            System.out.println(b.getId() + " - " + b.getTitle() + " - "
                               + b.getAuthor() + " - " + b.getYear());
        }
    }

    @Override
    public String getType() {
        return "TreeMapLibrary";
    }
}
