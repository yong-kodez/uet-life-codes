public class Circle extends Shape {
    public Circle(int x, int y) {
        super(x, y);
    }

    public void draw() {
        System.out.println("Drawing circle at (" + x + ", " + y + ")");
    }

    public void erase() {
        System.out.println("Erasing circle at (" + x + ", " + y + ")");
    }
}
