public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] tests = { {12, 9}, {1, 8}, {13, 19}, {4, 0}, 
                          {0, 0}, {-23, -2}, {-57, 19} };

        System.out.println("* Calculating GCDs");
        for (int[] arr : tests) {
            String format = "- GCD(" + arr[0] + ", " + arr[1] + ")"
                             + " = " + sol.gcd(arr[0], arr[1]);
            System.out.println(format);
        }
    }
}
