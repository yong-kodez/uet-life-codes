import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] tests = { {}, {9}, {9, 9, 4}, {10, 7, 10}, {-12, 8, 12, 4, 0},
                          {8, 4}, {-5, -10, -2}, {6, 6, 3, 3}, {8, 8, 8} };

        System.out.println("* Finding second largest nums");
        for (int[] arr : tests) {
            String format = "- " + Arrays.toString(arr) + ": " + sol.secondLargest(arr);
            System.out.println(format);
        }
    }
}
