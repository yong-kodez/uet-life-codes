public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();
        // Cat c = (Cat) a;
        // c.makeSound() ;

        if (a instanceof Cat) { Cat c = (Cat) a; }
        else System.out.println("This is not a Cat!");
    }
}
