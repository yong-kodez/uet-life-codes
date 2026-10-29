import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ArrayService {
    private List<Future<Integer>> results;

    public ArrayService() {
        this.results = new ArrayList<>();        
    }

    public void assignTasks() {
        ExecutorService es = Executors.newFixedThreadPool(5);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int len = sc.nextInt();
            int[] arr = new int[len];
            for (int j = 0; j < len; j++) {
                arr[j] = sc.nextInt();
            }
            results.add(es.submit(new Task(arr)));
        }

        es.shutdown();
        sc.close(); 
    }

    public void getResults() {
        int id = 0;
        int sum = 0;
        for (Future<Integer> future : results) {
            String fmt = " Array " + id + ": ";
            try {
                Integer res = future.get();
                if (res != null) {
                    sum += res;
                    fmt += res;
                } else {
                    fmt += "Not found";
                }
                id++;
                System.out.println(fmt);
                
            } catch (InterruptedException e) {
                System.err.println("Interrupted Exception");
            } catch (ExecutionException e) {
                System.err.println("Execution Exception");
            }
        }
        System.out.println(" Sum = " + sum);
    }    
}
