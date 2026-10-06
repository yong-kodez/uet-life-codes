import java.util.ArrayList;
import java.util.TreeMap;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Library<ArrayList<Book>> a = new Library<>(new ArrayList<Book>());
        Library<TreeMap<String, Book>> b = new Library<>(new TreeMap<String, Book>());
        Library<HashMap<String, Book>> c = new Library<>(new HashMap<String, Book>());

        Book b1 = new Book("B01", "bang", "tony", 1999);
        Book b3 = new Book("B01", "gang", "betty", 2000);
        Book b2 = new Book("B02", "gang", "betty", 2000);
        a.addBook(b1);
        b.addBook(b1);
        c.addBook(b1);

        ArrayList<Book> la = a.getStore();
        TreeMap<String, Book> lb = b.getStore();
        HashMap<String, Book> lc = c.getStore();

        System.out.println(la);
        System.out.println(lb);
        System.out.println(lc);

        a.addBook(b2);
        System.out.println(la);

        a.addBook(b3);
        System.out.println(la);
    }
}
