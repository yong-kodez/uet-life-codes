public class Main {
    public static void main(String[] args) {
        System.out.println("4) Prototype");
        ConfigCache cache = new ConfigCache();
        ImgConfig root = cache.get("default");

        ImgConfig custom01 = root.clone();
        ImgConfig custom02 = root.clone();

        custom01.setFilter("cold");
        custom02.setSize(1920, 1080);

        System.out.println("- Default: " + root);
        System.out.println("- Custom 1: " + custom01);
        System.out.println("- Custom 2: " + custom02);
        System.out.println();
    }
}
