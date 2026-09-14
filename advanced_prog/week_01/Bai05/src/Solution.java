public class Solution {
    public int gcd(int a, int b) {
        if (b == 0) {
          if (a == 0) return -1;
          return a;
        }

        int gcd = gcd(b, a % b);
        if (gcd < 0) return (-1)*gcd;
        return gcd;
    }
}
