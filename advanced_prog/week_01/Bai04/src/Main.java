public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] tests = { -2, 0, 5, 28, 92, 93, 94 };

        System.out.println("* Fibonacci numbers");
        for (int n : tests) {
            String format = "- n=" + n + ": " + sol.fibonacci(n);
            if (sol.fibonacci(n) == Long.MAX_VALUE)
                format += " (overflow)";

            System.out.println(format);
        }
    }
}
