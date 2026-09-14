public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] tests = { 0, 7, 42, 3007, 1500, 610320123, -9,
                        -14, -520, 1420072808, -2147483648 };
        System.out.println("* Reversing numbers");
        for (int n : tests) {
            String format = "- n=" + n + ": " + sol.reverse(n);
            if ((n != 0) && (sol.reverse(n) == 0))
                format += " (overflow)";
            
            System.out.println(format);
        }
    }
}
