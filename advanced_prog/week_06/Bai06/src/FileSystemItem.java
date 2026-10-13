public abstract class FileSystemItem {
    private String name;

    public FileSystemItem(String name) {
        this.name = name;
    }

    public String getName() { return this.name; }

    public abstract void print(String indent);
}
