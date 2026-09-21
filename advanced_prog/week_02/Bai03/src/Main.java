public class Main {
    public static void main(String[] args) {
        NumberWrapper n1 = new NumberWrapper(5);
        NumberWrapper n2 = new NumberWrapper(10);

        System.out.println("* Before:\n  - n1 = "+n1.getValue()+"\n  - n2 = "+n2.getValue());
        NumberWrapper.swap(n1, n2);
        System.out.println("* After:\n  - n1 = "+n1.getValue()+"\n  - n2 = "+n2.getValue());
    }
}
