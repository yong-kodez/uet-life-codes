public class Solution {
    public static long fibonacci(long n) {
        long[] store = {0, 1, 0};
        long res = 0;

        if (n < 0) return -1;
        else if (n <= 1) return store[(int)n];
        else {
            for (int i = 1; i < n; i++) {
                res = store[0] + store[1];
                if (res < 0) return Long.MAX_VALUE;

                store[0] = store[1];
                store[1] = res;                     
            }
            return res;
        }
    };
}
