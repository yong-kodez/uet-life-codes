public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> p1 = new Pair<>("Age", 1);
        Pair<String, String> p2 = new Pair<>("Student's ID", "SV001");
        Pair<Integer, Double> p3 = new Pair<>(105, 21.5);

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
    }
}
