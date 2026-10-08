public class Circle extends Shape {
    public Circle(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw() {
        System.out.println("Drawing circle at (" + x + ", " + y + ")");
    }

    @Override
    public void erase() {
        System.out.println("Erasing circle at (" + x + ", " + y + ")");
    }
}
