import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

public class PathTest {
    @Test
    void pathTest() {
        PathService service = new PathService();
        String result = service.buildPath("parent", "children.txt");
        String expected = "parent" + File.separator + "children.txt";
        assertEquals(expected, result);
    }
}


