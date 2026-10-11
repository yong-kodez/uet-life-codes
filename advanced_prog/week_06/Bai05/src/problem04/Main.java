public class Main {
    public static void main(String[] args) {
        System.out.println("4) Prototype");
        ConfigCache cache = new ConfigCache();
        ImgConfig root = cache.get("default");

        ImgConfig draft01 = root.clone();
        ImgConfig draft02 = root.clone();

        draft01.setFilter("cold");
        draft02.setSize(1920, 1080);

        System.out.println("- Default: " + root);
        System.out.println("- Custom 1: " + draft01);
        System.out.println("- Custom 2: " + draft02);
        System.out.println();
    }
}
