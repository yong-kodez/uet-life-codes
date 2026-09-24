public class NumberWrapper {
    private int val;

    public NumberWrapper() { this.val = 0; }
    public NumberWrapper(int val) { this.val = val; };

    public int getValue() { return this.val; }
    public void setValue(int value) { this.val = value; }

    public static void swap(NumberWrapper a, NumberWrapper b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
        // a.setValue(b.val);
        // b.setValue(temp);
    }
}
