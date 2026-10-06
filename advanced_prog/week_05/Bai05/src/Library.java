public interface Library {
    boolean addBook(Book b);
    Book searchBook(String id);
    Book removeBook(String id);
    void printStore();
    String getType();
}
