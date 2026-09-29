public class Main {
    public static void main(String[] args) {
        // ArrayUtils<Integer> arr = new ArrayUtils<>();
        Integer[] a1 = {5, 1, 3, 2};
        String[] a2 = {"Java", "C++", "Zig", "Python"};

        ArrayUtils.sort(a1);
        ArrayUtils.sort(a2);

        for (Integer i : a1) System.out.print(i + " ");
        System.out.println();
        for (String i : a2) System.out.print(i + " ");
        System.out.println();
    }
}
