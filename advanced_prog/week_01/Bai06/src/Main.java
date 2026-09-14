public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] tests = { -2, 1, 3, 25, 57, 1009 };

        System.out.println("* Checking primes");
        for (int n : tests) {
            String format = "- n=" + n + ": " + sol.isPrime(n);
            System.out.println(format);
        }
    }
}
