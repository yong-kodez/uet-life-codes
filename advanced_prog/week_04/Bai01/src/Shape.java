public abstract class Shape {
    protected int x, y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public abstract void draw();
    public abstract void erase();

    public void moveTo(int newX, int newY) {
        erase();
        x = newX;
        y = newY;
        draw();
    }
}
