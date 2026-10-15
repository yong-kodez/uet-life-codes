import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String sample1 = "Regular exercise is essential for maintaining good health. Exercise helps control weight, reduce the risk of chronic diseases, and improve mental health. Physical activities like walking, running, and swimming increase cardiovascular fitness. Moreover, regular exercise releases endorphins, which are natural mood lifters. Additionally, it helps improve sleep quality and boosts energy levels. Therefore, incorporating regular exercise into your daily routine is vital for a healthy and balanced life.";
        String sample2 = "Seldom does one have opportunity of seeing a fight between a tiger and a crocodile. I, however, had this opportunity one day when I went with my father into a forest in search of some wild plants. I had never been to a forest before. Therefore, whatever I saw in the forest interested me greatly. I looked at the rich vegetation all round as well as the variety of colourful flowers and birds, large and small. I saw the activity of some of the wild creatures, such as snakes, squirrels and insects. Occasionally, I heard the cry of some strange animal in pain, perhaps while being eaten by a larger animal. I also heard some rustling noises in the undergrowth; but I was not afraid of all these. Such things, I knew, were natural to the forest.";

        WordFrequency wf = new WordFrequency(sample1);

        List<String> uniques = wf.uniqueWords();
        List<String> mosts = wf.mostFreqWords();

        System.out.print(" - Unique words (1 time): ");
        printList(uniques);
        System.out.println();

        System.out.print(" - Most frequency words " + "(" + wf.getMostFreq() + " times): ");
        printList(mosts);
    }

    public static void printList(List<String> l) {
        for (String s : l) {
            System.out.print(" " + s + ",");
        }
        System.out.println();
    }
}
