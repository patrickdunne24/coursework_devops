import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Dex2HexTest {

    @Test
    public void testNoArgumentProvided() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Dex2Hex.main(new String[]{});

        String output = outputStream.toString().trim();
        assertEquals("Error: No input provided. Please provide an integer input.", output);

        System.setOut(System.out);  // Reset System.out
    }

    @Test
    public void testNonIntegerArgument() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Dex2Hex.main(new String[]{"abc"});

        String output = outputStream.toString().trim();
        assertEquals("Error: Invalid input. Please provide an integer.", output);

        System.setOut(System.out);  // Reset System.out
    }

    @Test
    public void testValidIntegerArgument() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Dex2Hex.main(new String[]{"24"});

        String output = outputStream.toString().trim();
        assertTrue(output.contains("Converting the Decimal Value 24 to Hex..."));
        assertTrue(output.contains("Hexadecimal representation is: 18"));

        System.setOut(System.out);  // Reset System.out
    }
}
