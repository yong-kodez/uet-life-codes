import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {
    private static final Logger logger = LoggerFactory.getLogger(Calculator.class);

    public static int divide(int a, int b) {
        logger.info("Chia hai số {} và {}", a, b);
        if (b == 0) {
            logger.error("Số chia bằng 0");
            throw new IllegalArgumentException();
        }
        return a / b;
    }

    public static int add(int a, int b) {
        logger.info("Cộng hai số {} và {}", a, b);
        return a + b;
    }

    public static int max(int a, int b) {
        logger.info("So sánh hai số {} và {}", a, b);
        if (a >= b) {
            return a;
        }
        return b;
    }
} 
