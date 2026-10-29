import java.util.Arrays;
import java.util.concurrent.Callable;

public class Task1 implements Callable<int[]> {
    private int id;
    private int[] arr;

    public Task1(int id, int[] arr) {
        this.id = id;
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
    public int[] call() {
        int[] primes = new int[arr.length];
        int count = 0;
        for (int n : arr) {
            if (isPrime(n)) {
                primes[count] = n;
                count++;
            }
        }

        primes = Arrays.copyOf(primes, count);
        System.out.println("Stage 1 - Array " + id + ": " + Arrays.toString(primes));
        return primes;         
    }
}
