import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ArrayService {
    private List<int[]> tasks;
    private List<Future<Integer>> results;

    public ArrayService() {
        this.tasks = new ArrayList<>();
        this.results = new ArrayList<>();        
    }

    public void assignTasks() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int len = sc.nextInt();
            int[] arr = new int[len];
            for (int j = 0; j < len; j++) {
                arr[j] = sc.nextInt();
            }
            tasks.add(arr);
        }
        sc.close(); 
    }

    public void active() {
        ExecutorService es = Executors.newFixedThreadPool(5);

        for (int[] task : tasks) {
            results.add(es.submit(new Task(task)));
        }
        es.shutdown();
    }

    public void getResults() {
        int id = 0;
        int sum = 0;
        for (Future<Integer> future : results) {
            String fmt = " Array " + id + ": ";
            try {
                Integer res = future.get();
                sum += res;
                fmt += res;
                
            } catch (InterruptedException e) {
                System.err.println("Interrupted Exception");
            } catch (ExecutionException e) {
                System.err.println("Execution Exception");
            } catch (NullPointerException e) {
                fmt += "Not found";
            } finally {
                id++;
                System.out.println(fmt);
            }
        }
        System.out.println(" Sum = " + sum);
    }    
}
