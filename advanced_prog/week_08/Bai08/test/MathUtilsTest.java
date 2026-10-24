import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathUtilsTest {
    @BeforeAll
    static void startTests() {
        System.out.println("=== Start running MathUtilsTest ===");
    }

    @Test
    void maxTest() {
        assertEquals(5, MathUtils.max(5, 0));
        assertEquals(-4, MathUtils.max(-9, -4));
        assertEquals(28, MathUtils.max(28, 28));
        assertEquals(Integer.MAX_VALUE, MathUtils.max(0, Integer.MAX_VALUE));
        assertEquals(Integer.MIN_VALUE, MathUtils.max(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    @Test
    void divideTest() {
        assertEquals(2, MathUtils.divide(4, 2));
        assertEquals(-2, MathUtils.divide(5, -2));
        assertThrows(IllegalArgumentException.class, () -> MathUtils.divide(5, 0));
    }

    @AfterAll
    static void endTests() {
        System.out.println("=== Ended ===");
    }
}
