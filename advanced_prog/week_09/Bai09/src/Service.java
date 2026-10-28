import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Service {
    private static final Logger logger = LoggerFactory.getLogger(Service.class);

    public void process(String name, double amount) {
        logger.info("Start processing {} with {}$", name, amount);
        try {
            if (amount < 0) {
                throw new IllegalArgumentException();
            }
            logger.info("Success processing {}", name);
        } catch (Exception e) {
            logger.error("Catch exception when processing {} with {}$", name, amount);
        }
    }
}
