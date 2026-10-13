public class Main {
    public static void main(String[] args) {
        Folder tree = new Folder("root", 
            new Folder("docs",
                new FileItem("a.txt", 12),
                new FileItem("b.txt", 8),
                new Shortcut("a-shortcut", "/root/docs/a.txt")
            ),
            new FileItem("README.md", 4)
        );
        tree.print("");
    }
}
