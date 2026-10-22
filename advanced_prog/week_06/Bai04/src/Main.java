public class Main {
    public static void main(String[] args) {
        System.out.println("a) Adapter");
        SorterAdapter adapter = new SorterAdapter();
        int[] arr = {5, 2, 6, 3, 1};
        adapter.sort(arr);

        System.out.print("- After sorted: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();

        System.out.println("b) Prototype");
        TemplateCache cache = new TemplateCache();
        ReportTemplate root = cache.get("report01");
        ReportTemplate clone1 = root.clone();
        ReportTemplate clone2 = root.clone();
        
        clone1.setTitle("Report 2");
        clone2.setTitle("Report 3");

        System.out.println(root);
        System.out.println(clone1);
        System.out.println(clone2);
    }
}
