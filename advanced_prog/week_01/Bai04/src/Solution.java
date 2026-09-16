public class Solution {
    public static long fibonacci(long n) {
        long a = 0;
        long b = 1;
        long res = 0;

        if (n < 0) return -1;
        if (n <= 1) return n;

        for (long i = 1; i < n; i++) {
            res = a + b;
            if (res < 0) return Long.MAX_VALUE;
            a = b;
            b = res;
        }
        return res;
    };
}
