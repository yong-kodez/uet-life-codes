import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of media items: ");
        int n = sc.nextInt();        
        LibrarySection<Book> bookSection = new LibrarySection<>();
        LibrarySection<Dvd> dvdSection = new LibrarySection<>();

        for (int i = 0; i < n; i++) {
            System.out.print(" - Item " + (i+1) + ": ");
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();

            if ("B".equals(type)) {
                String author = sc.next();
                int pages = sc.nextInt();
                bookSection.addItem(new Book(id, name, author, pages));
            } else if ("D".equals(type)) {
                String director = sc.next();
                int duration = sc.nextInt();
                dvdSection.addItem(new Dvd(id, name, director, duration));
            }
        }
        System.out.println("Book Section: ");
        bookSection.detail();
        // for (Book b : bookSection) b.detail();
        System.out.println();
        System.out.println("DVD Section: ");
        dvdSection.detail();
        // for (Dvd d : dvdSection) d.detail();
    }
}
