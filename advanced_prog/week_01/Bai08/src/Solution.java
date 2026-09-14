public class Solution {
    public boolean isPalindrome(int n) {
        int temp = n;
        int div = 1;
        int f_digit = 0;
        int l_digit = 0;

        while (temp/10 != 0) {
            div*=10;         
            temp/=10;
        }
        if (div == 1) return true;

        while (n != 0) {
            f_digit = n / div;
            l_digit = n % 10;
            if ((f_digit != l_digit)) return false;            

            n = (n % div) / 10;
            div/=100;
        }
        return true;
    }
}
