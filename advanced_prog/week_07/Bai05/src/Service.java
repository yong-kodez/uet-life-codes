import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Service {
    private int workers;
    private List<String> logs;
    // private List<Package> tasks;

    public Service(int workers) {
        this.workers = workers;
        this.logs = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    public List<Package> assignTasks(int num) {
        Scanner sc = new Scanner(System.in);
        List<Package> tasks = new ArrayList<>();

        System.out.println("Package infomations (id/processMs):");
        for (int i = 0; i < num; i++) {
            System.out.print("  + package " + (i+1) + ": ");
            String id = sc.next();
            long processMs = sc.nextLong();
            tasks.add(new Package(id, processMs));
        }
        return tasks;
    }

    public void logWrite()

    public void active(List<Package> tasks) {
        ExecutorService pool = Executors.newFixedThreadPool(workers);
        for (Package pack : tasks) {
            pool.submit(pack);
        }

        for ()
        pool.shutdown(); 
    }
}
