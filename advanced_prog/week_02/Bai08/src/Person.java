public class Person {
    private String name;
    private Person me;

    public Person(String name) {
        this.name = name;
    }

    public void setMe(Person other) {
        this.me = other;
    }

    public String getName() { return this.name; }
    public Person getMe() { return this.me; }
}
