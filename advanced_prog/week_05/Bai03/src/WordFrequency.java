import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class WordFrequency {
    private String pg;

    public WordFrequency(String pg) {
        this.pg = pg;        
    }

    public String normalize() {
        String buf = pg;
        String[] regs = {".", ",", "!", "\"", "\'", "(", ")",
                       ":", "[", "]", "{", "}", "-", ";"};
        for (String reg : regs) {
            buf = buf.replace(reg, "");
        }
        buf = buf.toLowerCase();
        return buf;
    }

    public HashMap<String, Integer> countFreq() {
        String normie = this.normalize();
        HashMap<String, Integer> freq = new HashMap<>();

        String clean = this.normalize();
        String[] words = clean.split("\\s+");
        for (String word : words) {
            if (freq.containsKey(word)) freq.put(word, freq.get(word) + 1);
            else freq.put(word, 1);
        }
        return freq;
    }

    public List<String> getKeysByValue(int value) {
        HashMap<String, Integer> freq = this.countFreq();
        List<String> arr = new ArrayList<>(freq.keySet());
        List<String> rs = new ArrayList<>();

        for (String s : arr) {
            if (freq.get(s) == value) {
                rs.add(s);
            }
        }
        return rs;
    }

    public List<String> uniqueWords() {
        HashMap<String, Integer> freq = this.countFreq();
        List<String> arr = new ArrayList<>(freq.keySet());

        List<String> rs = this.getKeysByValue(1);
        rs.sort((s1, s2) -> s1.compareTo(s2)); 
        return rs;
    }

    public int getMostFreq() {
        HashMap<String, Integer> freq = this.countFreq();
        return Collections.max(freq.values());
    }

    public List<String> mostFreqWords() {
        int max = getMostFreq();

        List<String> rs = this.getKeysByValue(max);
        rs.sort((s1, s2) -> s1.compareTo(s2));
        return rs;
    }
}
