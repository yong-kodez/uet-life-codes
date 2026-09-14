public class Solution {
    public int sumOfDigits(int n) {
        int res = 0;
        
        while (n != 0) {
            res = res + (n % 10);
            n/=10;
        }
        if (res < 0) return res*(-1);
        return res;
    }
}
