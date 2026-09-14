public class Solution {
    public int secondLargest(int[] arr) {
        if (arr.length < 2) return -1;

        int largest = arr[0];
        int sec_largest = arr[0];
        
        for (int n : arr) {
            if (n > largest) {
                sec_largest = largest;
                largest = n;
            }
            else if (n > sec_largest) sec_largest = n;    
        }

        if (sec_largest == largest) return -1;
        return sec_largest;
    }
}
