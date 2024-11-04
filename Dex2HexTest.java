import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Dex2HexTest {

    @Test
    public void testValidIntegerInput() {
        String[] args = {"255"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Dex2Hex.main(args);

        assertTrue(output.toString().contains("Hexadecimal representation is: FF"));
    }

    @Test
    public void testNoInput() {
        String[] args = {};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Dex2Hex.main(args);

        assertTrue(output.toString().contains("Error: Input argument is required."));
    }

    @Test
    public void testNonIntegerInput() {
        String[] args = {"hello"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Dex2Hex.main(args);

        assertTrue(output.toString().contains("Error: Please enter a valid integer."));
    }
}

