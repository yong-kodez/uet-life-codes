public class Calculator {

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException();
        }
        return a / b;
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int max(int a, int b) {
        if (a >= b) {
            return a;
        }
        return b;
    }
} 
