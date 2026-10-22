public class Main {
    public static void main(String[] args) {
        String type = "win";
        if (args.length > 0) type = args[0];

        UIFactory factory;
        if (type.equals("mac")) {
            factory = new MacFactory();
        } else factory = new WindowsFactory();

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();
        checkbox.render();
    }
}
