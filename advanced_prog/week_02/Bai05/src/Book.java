public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public boolean equals(Book o) {
        return ((this.title == o.title) &&
                (this.author == o.author) &&
                (this.price) == o.price);
    }
}
