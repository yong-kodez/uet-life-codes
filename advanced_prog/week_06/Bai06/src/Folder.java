import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Folder extends FileSystemItem {
    private List<FileSystemItem> children = new ArrayList<>();

    public Folder(String name, FileSystemItem... items) {
        super(name);
        children.addAll(Arrays.asList(items));
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Folder: " + this.getName());
        indent += "  ";
        for (FileSystemItem fsi : children) {
            fsi.print(indent);
        }
    }
}
