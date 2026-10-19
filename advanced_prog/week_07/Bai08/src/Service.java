import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class Service {
    private List<Future<Integer>> phase2;
    
    public Service() {
        this.phase2 = new ArrayList<>();
    }

    public void assignTasks() {
        ExecutorService pool1 = Executors.newFixedThreadPool(5);
        ExecutorService pool2 = Executors.newFixedThreadPool(5);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int len = sc.nextInt();
            int[] arr = new int[len];
            for (int j = 0; j < len; j++) {
                arr[j] = sc.nextInt();
            }
            phase2.add(pool2.submit(new Task2(i, pool1.submit(new Task1(i, arr)))));
        }
        pool1.shutdown();
        pool2.shutdown();
        sc.close();                 
    }

    public void printTotal() {
        int total = 0;
        for (Future<Integer> future : phase2) {
            try {
                total += future.get();
                
            } catch (InterruptedException e) {
                System.err.println("Interrupted Exception");
            } catch (ExecutionException e) {
                System.err.println("Execution Exception");
            }
        }
        System.out.println("Total = " + total);
    }
}
