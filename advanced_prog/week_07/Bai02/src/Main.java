import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 
        int[] arr2 = {-5, -3, -1, 0, 1, 3, 5};

        System.out.println("- Sum 1 = " + ArraySumByPool(arr1, 4));
        System.out.println("- Sum 2 = " + ArraySumByPool(arr2, 2));
        
    }

    public static long ArraySumByPool(int[] arr, int num) {
        ExecutorService es = Executors.newFixedThreadPool(num);
        List<Future<Integer>> results = new ArrayList<>();
        int len = arr.length;
        long finalResult = 0;

        for (int i = 0; i < num; i++) {
            int id = i;
            Callable<Integer> task = () -> {
                int start = (len * id) / num;
                int end = (len * (id + 1)) / num;
                Integer result = 0; 

                for (int j = start; j < end; j++) {
                    result += arr[j];
                }
                return result;                
            };
            Future<Integer> future = es.submit(task);
            results.add(i, future);
        }

        for (int i = 0; i < num; i++) {
            try { finalResult += results.get(i).get(); }
            catch (InterruptedException e) {}
            catch (ExecutionException e) {}
        }

        es.shutdown(); 
        return finalResult;
    }
}
