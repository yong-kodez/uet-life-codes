import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;

public class WordCounter {
    public String analyze(String text) {
        String buf = text;
        String[] regs = {".", ",", "!", "\"", "\"", "(", ")",
                       ":", "[", "]", "{", "}", "-", ";"};
        for (String reg : regs) {
            buf = buf.replace(reg, "");
        }
        buf = buf.toLowerCase();
        return buf;
    }

    public ArrayList<Pair<String, Integer>> storeArrayList(String text) {
        String clean = this.analyze(text);
        String[] words = clean.split("\\s+");
        ArrayList<Pair<String, Integer>> arr = new ArrayList<>();

        for (String word : words) {
            for (Pair<String, Integer> p : arr) {
                if (word.equals(p.getKey())) p.setVal(p.getVal() + 1);
                else arr.add(new Pair<String, Integer>(word, 1));
            }
        }
        return arr;
    }

    public HashMap<String, Integer> storeHashMap(String text) {
        String clean = this.analyze(text);
        String[] words = clean.split("\\s+");
        HashMap<String, Integer> map = new HashMap<>();        

        for (String word : words) {
            if (map.containsKey(word)) map.put(word, map.get(word) + 1);
            else map.put(word, 1);
        }
        return map;
    }

    public void displayResult(String text) {
        HashMap<String, Integer> map = this.storeHashMap(text);
        
        System.out.print(" - List (k=v): ");
        for (String k : map.keySet()) {
            System.out.print(k + "=" + map.get(k) + ", ");
        }
        System.out.println();
    }

    public void printMost(String text) {
        HashMap<String, Integer> map = this.storeHashMap(text);
        int max = Collections.max(map.values());

        System.out.print(" - Most appear words (" + max + " times): ");
        for (String k : map.keySet()) {
            if (max == map.get(k)) System.out.print(k + ", ");
        }
        System.out.println();
    }
}
