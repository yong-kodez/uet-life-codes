public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] tests = { 0, 4, 3002130, -3, -120320,
                        1290012401, -2147483648 };
        System.out.println("* Calculating sums");
        for (int n : tests) {
            String format = "- n=" + n + ": " + sol.sumOfDigits(n);
            System.out.println(format);
        }
    }
}
