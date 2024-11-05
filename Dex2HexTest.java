import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class Dex2HexTest {

    @Test
    public void testMainWithValidInput() {
        // Capture System.out output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Simulate command-line arguments
        String[] args = {"31"};
        Dex2Hex.main(args);

        // Expected output
        String expectedOutput = "Converting the Decimal Value 31 to Hex....\n" +
                                "The Hexadecimal representation is: 1F\n";
        
        assertEquals(expectedOutput, outputStream.toString());

        // Restore original System.out
        System.setOut(System.out);
    }

    @Test
    public void testMainWithNoInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String[] args = {};  // No arguments provided
        Dex2Hex.main(args);

        String expectedOutput = "Error: No input provided Please provide an integer input.\n";
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }

    @Test
    public void testMainWithInvalidInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String[] args = {"abc"};  // Non-integer input
        Dex2Hex.main(args);

        String expectedOutput = "Error: Invalid input. Please provide an integer.\n";
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }
}
