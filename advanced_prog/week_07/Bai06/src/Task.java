import java.util.concurrent.Callable;

public class Task implements Callable<Integer> {
    private int[] arr;

    public Task(int[] arr) {
        this.arr = arr;
    }

    @Override
    public Integer call() {
        Integer largest = null;
        Integer secondLargest = null;

        if (arr.length < 2) return null; 
        for (Integer n : arr) {
            if (largest == null || n > largest) {
                secondLargest = largest;
                largest = n;
            } else if (secondLargest == null || n > secondLargest ) {
                secondLargest = n;
            }
        }

        if (secondLargest == largest) return null;
        return secondLargest;
    }
}
