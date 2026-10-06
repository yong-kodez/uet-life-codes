import java.util.ArrayList;
import java.util.TreeMap;
import java.util.HashMap;

public class Library<T> {
    private T store;

    public Library(T store) {
        this.store = store;
    }

    public T getStore() { return this.store; }

    public boolean isExisted(Book newBook) {
        switch (store) {
            case ArrayList<?> arr -> {
                for (Object obj : arr) {
                    if (obj instanceof Book b && newBook.getId().equals(b.getId()))
                        return true;
                }
                return false;
            }            
            case TreeMap<?, ?> map -> {
                if (map.containsKey(newBook.getId()))
                    return true;
                return false;
            }
            case HashMap<?, ?> map -> {
                if (map.containsKey(newBook.getId()))
                    return true;
                return false;
            }
            default -> {}
        }
        return false;
    }

    public void addBook(Book b) {
        if (!this.isExisted(b))
            switch (store) {
                case ArrayList arr -> arr.add(b);
                case TreeMap map -> map.put(b.getId(), b);
                case HashMap map -> map.put(b.getId(), b);
                default -> {}
            }
    }
}
