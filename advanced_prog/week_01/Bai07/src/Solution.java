public class Solution {
    public int reverse(int n) {
        int high_limit = Integer.MAX_VALUE / 10;
        int low_limit = Integer.MIN_VALUE / 10;

        int res = 0;
        int digit = 0;
        while (n != 0) {
            digit = n % 10;
            if ((res > high_limit) || (res < low_limit)) return 0;
            res = res*10 + digit;
            n/=10;
        }
        return res;
    }
}
