import org.junit.jupiter.api.Test;

public class ServiceTest {
    @Test
    void logTest() {
        Service service = new Service();

        service.process("order01", 200);
        service.process("order02", -230);
    }    
}
