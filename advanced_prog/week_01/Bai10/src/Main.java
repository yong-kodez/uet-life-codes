import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] tests = { {}, {9}, {4, 9}, {-12, 8, 12, 4, 0},
                          {6, 2, 7, 8}, {5, 2, 5}, {8, 8, 8, 8} };

        System.out.println("* Finding second largest nums");
        for (int[] arr : tests) {
            String format = "- " + Arrays.toString(arr) + ": " + sol.secondLargest(arr);
            System.out.println(format);
        }
    }
}
