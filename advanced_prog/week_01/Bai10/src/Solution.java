public class Solution {
    public int secondLargest(int[] arr) {
        if (arr.length < 2) return -1;

        int largest = arr[0];
        int sec_largest = Integer.MIN_VALUE;
        boolean found = false;
        
        for (int n : arr) {
            if (n > largest) {
                sec_largest = largest;
                largest = n;
                found = true;
            }
            else if (n > sec_largest && n < largest) {
                sec_largest = n;    
                found = true;
            }
        }

        if (!found) return -1;
        return sec_largest;
    }
}
