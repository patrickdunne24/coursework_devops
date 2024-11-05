import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Dex2HexTest {

    @Test
    public void testNoArgumentProvided() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Dex2Hex.main(new String[]{});  // No arguments
        });
        assertEquals("Error: Input argument is required.", exception.getMessage());
    }

    @Test
    public void testNonIntegerInput() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            Dex2Hex.main(new String[]{"abc"});  // Non-integer input
        });
        assertEquals("Error: Please enter a valid integer.", exception.getMessage());
    }

    @Test
    public void testValidIntegerInput() {
        assertDoesNotThrow(() -> {
            Dex2Hex.main(new String[]{"255"});  // Valid integer input
        });
    }
}
