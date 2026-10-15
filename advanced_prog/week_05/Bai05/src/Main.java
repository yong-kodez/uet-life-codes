import java.util.Scanner;
import java.util.TreeMap;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayListLibrary allib = new ArrayListLibrary();
        TreeMapLibrary tmlib = new TreeMapLibrary();
        HashMapLibrary hmlib = new HashMapLibrary();

        Book b1 = new Book("B01", "Book1", "tony", 2000);
        Book b2 = new Book("B02", "Book2", "betty", 2001);
        Book b3 = new Book("B03", "Book3", "hestty", 1000);
        Book b4 = new Book("B04", "Book4", "ghostty", 1999);
        Book b5 = new Book("B05", "Book5", "kitty", 2010);

        addAll(allib, b1, b2, b3, b4, b5);
        addAll(tmlib, b1, b2, b3, b4, b5);
        addAll(hmlib, b1, b2, b3, b4, b5);

        // Scanner sc = new Scanner(System.in);
        // System.out.print("Number of books: ");
        // int n = sc.nextInt();
        // System.out.println("(id/title/author/year)");

        // for (int i = 0; i < n; i++) {
        //     System.out.print(" - Book " + (i+1) + ": ");
        //     String id = sc.next();
        //     String title = sc.next();
        //     String author = sc.next();
        //     int year = sc.nextInt();
        //     addHandler(allib, new Book(id, title, author, year));
        //     addHandler(tmlib, new Book(id, title, author, year));
        //     addHandler(hmlib, new Book(id, title, author, year));
        // }

        System.out.println();
        searchHandler(allib, "B01");
        searchHandler(tmlib, "B01");
        searchHandler(hmlib, "B01");

        System.out.println();
        removeHandler(allib, "B02");
        removeHandler(tmlib, "B02");
        removeHandler(hmlib, "B02");

        System.out.println();
        System.out.println(" * ArrayList Library");
        allib.printStore();
        System.out.println(" * TreeMap Library");
        tmlib.printStore();
        System.out.println(" * HashMap Library");
        hmlib.printStore();
    }

    public static void addHandler(Library lb, Book b) {
        if (lb.addBook(b)) System.out.println("+ Added book " + b.getId() + " to " + lb.getType());
        else System.out.println("  [!] Add failed");
    }

    public static void removeHandler(Library lb, String id) {
        Book b = lb.removeBook(id);
        if (b != null) System.out.println("+ Removed book " + b.getId() + " from " + lb.getType());
        else System.out.println("  [!] Remove failed");
    }
    
    public static void searchHandler(Library lb, String id) {
        Book b = lb.searchBook(id);
        System.out.println("+ Searching book " + id);
        if (b != null) System.out.println(" --> " + b.getId() + " - " + b.getTitle() +
                                          " - " + b.getAuthor() + " - " + b.getYear());
        else System.out.println("  [!] Search not found");
    }

    public static void addAll(Library lib, Book... books) {
        int num = books.length;
        for (int i = 0; i < num; i++) {
            lib.addBook(books[i]);
        }
    }
}
