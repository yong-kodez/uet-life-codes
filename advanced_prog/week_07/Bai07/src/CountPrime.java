import java.util.concurrent.Callable;

public class CountPrime implements Callable<Integer> {
    private int[] arr;

    public CountPrime(int[] arr) {
        this.arr = arr;        
    }
    
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    @Override
    public Integer call() {
        Integer count = 0;
        for (int n : arr) {
            if (isPrime(n)) count += 1;
        }
        return count;
    }
    
}
