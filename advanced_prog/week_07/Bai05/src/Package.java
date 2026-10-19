import java.util.concurrent.Callable;

public class Package implements Callable<Boolean> {
    private String id;
    private long processMs;

    public Package(String id, long processMs) {
        this.id = id;
        this.processMs = processMs;
    }

    public String getId() { return this.id; }

    @Override
    public Boolean call() {
        System.out.println("Start " + id);
        try { Thread.sleep(processMs); }
        catch (InterruptedException e) {}

        if (processMs > 1500) return false;
        return true;
    }
}
