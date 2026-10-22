// Code Smell:
// - Switch Statements: Dùng nhiều lệnh if kiểm tra chuỗi shapeType để rẽ nhánh hành vi.
// - Magic Number: Sử dụng số 3.14159 trực tiếp và tham số b dư thừa khi tính diện tích hình tròn
// 
// Tại sao là vấn đề: Vi phạm nguyên lý Open/Closed Principle (OCP).
// Mỗi khi muốn thêm một hình mới , ta lại phải mở hàm getArea ra sửa và thêm if.
// Việc truyền tham số b không dùng tới khi tính hình tròn rất dễ gây nhầm lẫn
//
// Kỹ thuật Refactor: Thay thế câu lệnh if bằng tính đa hình
public double getArea(String shapeType, double a, double b) {
    if (shapeType.equals("rectangle")) return a * b;
    if (shapeType.equals("triangle")) return 0.5 * a * b;
    if (shapeType.equals("circle")) return 3.14159 * a * a;
    return -1;
}

// Sau khi Refactor
interface Shape {
    double getArea();
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}

class Circle implements Shape {
    private static final double PI = 3.14159; 
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return PI * radius * radius;
    }
}
