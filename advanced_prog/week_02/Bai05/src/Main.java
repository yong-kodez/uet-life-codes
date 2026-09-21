public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Book with a name", "tony", 7);
        Book b2 = new Book("Papers with a price", "ynot", 9);
        Book b3 = new Book("Book with a name", "tony", 7);

        System.out.println("- b1 equals b2: " + (b1.equals(b2)));
        System.out.println("- b1 == b3: " + (b1 == b3));
        System.out.println("- b1 equals b3: " + (b1.equals(b3)));
    }
}
