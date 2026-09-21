public class Main {
    public static void main(String[] args) {
        Person p = new Person("tony");
        p.setMe(p);
        System.out.println(p.getMe().getName());
        // Person m = p;
        p = null;
        // System.out.println(m.getName());
        // System.out.println(p.getMe().getName());
    }
}
