import java.io.File;

public class PathService {
    public String buildPath(String folder, String file) {
        return folder + File.separator + file;
    }
}
