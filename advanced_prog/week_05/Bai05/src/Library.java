public interface Library {
    void addBook(Book b);
    Book searchBook(String id);
    void removeBook(Book b);
    void printStore();
}
