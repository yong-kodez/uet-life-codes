public class Customer {
    private int id;
    private String name;

    private static int tick = 1;
    
    public Customer(String name) {
        this.id = tick;
        this.name = name;
        tick++;
    }

    public String getName() { return this.name; }
}
