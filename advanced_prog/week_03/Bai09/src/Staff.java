public abstract class Staff implements IPayable {
    private String id;
    private String name;

    public Staff(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return this.id; }
    public String getName() { return this.name; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}
