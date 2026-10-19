import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Task2 implements Callable<Integer> {
    private int id;
    private Future<int[]> phase1;

    public Task2(int id, Future<int[]> phase1) {
        this.id = id;
        this.phase1 = phase1;
    }
    
    public int expSum(int[] arr, int exp) {
        int sum = 0;
        for (int n : arr) {
            sum += Math.powExact(n, exp);
        }
        return sum;
    }

    @Override
    public Integer call() {
        try {
            int[] arr = phase1.get();
            int len = arr.length;
            int sum = 0;
            String type = "";

            if (len % 2 == 0) {
                sum = expSum(arr, 2);                                
                type = "squares";
            } else {
                sum = expSum(arr, 3);                                
                type = "cubes";
            }
            System.out.println("Stage 2 - Array " + id +
                               ": sum of " + type + " = " + sum);

            return sum;
            
        } catch (InterruptedException e) {
            System.err.println("Interrupted Exception");
        } catch (ExecutionException e) {
            System.err.println("Execution Exception");
        }
        return 0;
    }
}
