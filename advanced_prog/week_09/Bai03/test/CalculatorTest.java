import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    void divideTest() {
        assertEquals(2, Calculator.divide(4, 2));
        assertEquals(-2, Calculator.divide(5, -2));
        assertThrows(IllegalArgumentException.class, () -> Calculator.divide(5, 0));
    }

    @Test
    void addTest() {
        assertEquals(10, Calculator.add(7, 3));
        assertEquals(0, Calculator.add(-3, 3));

        // Lỗi ở đây
        assertEquals(10, Calculator.add(2, 3));
    }
    
    @Test
    void maxTest() {
        assertEquals(5, Calculator.max(5, 0));
        assertEquals(-4, Calculator.max(-9, -4));
        assertEquals(28, Calculator.max(28, 28));
        assertEquals(Integer.MAX_VALUE, Calculator.max(0, Integer.MAX_VALUE));
        assertEquals(Integer.MIN_VALUE, Calculator.max(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }
}
