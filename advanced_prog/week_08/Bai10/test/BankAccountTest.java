import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {
    private BankAccount account;
    
    @BeforeEach
    void setUp() {
        account = new BankAccount("25020508", "tony", 500);
    }

    @Test
    void depositValidTest01() {
        account.deposit(100);
        assertEquals(600, account.getBalance());
    }
    @Test
    void depositValidTest02() {
        account.deposit(0.01);
        assertEquals(500.01, account.getBalance(), 0.0001);
    }
    @Test
    void depositInvalidTest01() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-0.01);
        });
    }
    @Test
    void depositInvalidTest02() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(0);
        });
    }

    @Test
    void withdrawValidTest01() {
        assertEquals(true, account.withdraw(499.99));
    }
    @Test
    void withdrawValidTest02() {
        assertEquals(true, account.withdraw(200));
    }
    @Test
    void withdrawInvalidTest01() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(0);
        });
    }
    @Test
    void withdrawInvalidTest02() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-0.01);
        });
    }
    @Test
    void withdrawInvalidTest03() {
        assertEquals(false, account.withdraw(600));
    }
    @Test
    void withdrawInvalidTest04() {
        assertEquals(false, account.withdraw(500.01));
    }

    @Test
    void sequenceTest() {
        account = new BankAccount("25020508", "tony");
        assertEquals(0.0, account.getBalance());

        account.deposit(500);
        assertEquals(500, account.getBalance());

        assertEquals(true, account.withdraw(200));
        assertEquals(false, account.withdraw(400));

        assertEquals(300, account.getBalance());
    }
}
