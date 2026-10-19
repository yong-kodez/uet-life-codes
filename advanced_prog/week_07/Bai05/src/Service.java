import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Service {
    private int workers;
    private List<String> logs;
    private List<Package> tasks;
    private Map<String, Future<Boolean>> results;
    private AtomicInteger successPackages = new AtomicInteger(0);

    public Service(int workers) {
        this.workers = workers;
        this.logs = new ArrayList<>();
        this.results = new HashMap<>();
        this.tasks = new ArrayList<>();
    }

    public void assignTasks(int num) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Package infomations (id/processMs):");
        for (int i = 0; i < num; i++) {
            System.out.print("  + package " + (i+1) + ": ");
            String id = sc.next();
            long processMs = sc.nextLong();
            tasks.add(new Package(id, processMs));
        }
        sc.close();
    }

    public synchronized void logWrite(String id, Future<Boolean> future) {
        try {
            if (future.get()) {
                logs.add("DONE " + id);
                successPackages.incrementAndGet();
            }
            else logs.add("FAIL " + id);
        } catch (InterruptedException e) {
            System.err.println("Interrupted Exception");
        } catch (ExecutionException e) {
            System.err.println("Execution Exception");
        }
    }

    public int getSuccess() {
        return successPackages.get();
    }

    public void active() {
        ExecutorService pool = Executors.newFixedThreadPool(workers);

        for (Package pack : tasks) {
            results.put(pack.getId(), pool.submit(pack));
        }
        for (String key : results.keySet()) {
            logWrite(key, results.get(key));
        }
        pool.shutdown(); 
    }

    public void printLog() {
        System.out.println(" * LOG");
        for (String log : logs) {
            System.out.println(log);
        }
    }
}
