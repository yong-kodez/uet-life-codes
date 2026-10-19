import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Service {
    private int mostPrimes;    
    private List<Future<Integer>> futures;
    private List<Integer> results;

    public Service() {
        this.mostPrimes = 0;
        this.futures = new ArrayList<>();        
        this.results = new ArrayList<>();
    }

    public void assignTasks() {
        Scanner sc = new Scanner(System.in);
        ExecutorService pool = Executors.newFixedThreadPool(5);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int len = sc.nextInt();
            int[] arr = new int[len];
            for (int j = 0; j < len; j++) {
                arr[j] = sc.nextInt();
            }
            futures.add(pool.submit(new CountPrime(arr)));
        }

        pool.shutdown();
        sc.close(); 
    }

    public void calculateResults() {
        for (Future<Integer> future : futures) {
            try {
                int primes = future.get();
                results.add(primes);
                if (primes > mostPrimes) mostPrimes = primes;

            } catch (InterruptedException e) {
                System.err.println("Interrupted Exception");
            } catch (ExecutionException e) {
                System.err.println("Execution Exception");
            }
        }        
    }

    public void printResults() {
        String mostPrimesArrays = "";
        for (int i = 0; i < results.size(); i++) {
            int primes = results.get(i);
            System.out.println(" Array " + i + ": " + primes);
            if (primes == mostPrimes) {
                if (mostPrimesArrays.equals(""))
                    mostPrimesArrays += "Array " + i;
                else mostPrimesArrays += ", Array " + i;
            }
        }
        System.out.println(" Most primes: " + mostPrimesArrays + " with " + mostPrimes + " primes");
    }
}
