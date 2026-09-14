public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] tests = { 0, 9, 121, 3010, 200012, -5, -312,
                        -212, 1234554321, -2098118902 };

        System.out.println("* Checking palindromes");
        for (int n : tests) {
            String format = "- n=" + n + ": " + sol.isPalindrome(n);
            System.out.println(format);
        }
    }
}
