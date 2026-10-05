import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String sp1 = "Regular exercise is essential for maintaining good health. Exercise helps control weight, reduce the risk of chronic diseases, and improve mental health. Physical activities like walking, running, and swimming increase cardiovascular fitness. Moreover, regular exercise releases endorphins, which are natural mood lifters. Additionally, it helps improve sleep quality and boosts energy levels. Therefore, incorporating regular exercise into your daily routine is vital for a healthy and balanced life.";
        WordCounter wc = new WordCounter();
        
        long start = System.currentTimeMillis();
        ArrayList<Pair<String, Integer>> arr = wc.storeArrayList(sp1);        
        long end = System.currentTimeMillis();
        long timeTaken = end - start;
        System.out.println(" - Time taken by ArrayList: " + timeTaken);

        start = System.currentTimeMillis();
        HashMap<String, Integer> map = wc.storeHashMap(sp1);        
        end = System.currentTimeMillis();
        timeTaken = end - start;
        System.out.println(" - Time taken by HashMap: " + timeTaken);

        System.out.println();
        wc.displayResult(sp1);
        System.out.println();
        wc.printMost(sp1);
    }
}
