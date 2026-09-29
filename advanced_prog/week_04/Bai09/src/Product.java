public class Product {
    private String id;
    private String name;
    
    public Product(String id, String name) {
        this.id = id;
        this.name = name;        
    }

    public String getId() { return this.id; }
    public String getName() { return this.name; }

    public void setId() { this.id = id; }
    public void setName() { this.name = name; }

    public String detail() {
        return this.name + " - ";
    }
}
