public class Shortcut extends FileSystemItem {
    private String target;

    public Shortcut(String name, String target) {
        super(name);
        this.target = target;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Shortcut: " + this.getName()
                           + " -> " + target);
    }
}
