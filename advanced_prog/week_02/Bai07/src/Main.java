public class Main {
    public static void main(String[] args) {
        Product laptop = new Product("ASUS", 1000);
        Product phone = new Product("Xiaomi", 500);
        Product[] arr = {laptop, phone};

        Inventory store = new Inventory(arr);
        System.out.println("\t----Before----");
        store.printInv();
        
        arr[0].setPrice(5000);
        System.out.println("\t----After----");
        store.printInv();
    }
}
