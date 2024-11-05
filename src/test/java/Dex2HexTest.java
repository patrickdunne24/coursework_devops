import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Dex2HexTest {

    @Test
    public void testConvertSimpleValues() {
        Dex2Hex converter = new Dex2Hex();
        assertEquals("Expected hex output for 10", "A", converter.convert(10));
        assertEquals("Expected hex output for 31", "1F", converter.convert(31));
        assertEquals("Expected hex output for 255", "FF", converter.convert(255));
    }

    @Test
    public void testConvertEdgeCases() {
        Dex2Hex converter = new Dex2Hex();
        assertEquals("Expected hex output for 0", "0", converter.convert(0));
        assertEquals("Expected hex output for 1", "1", converter.convert(1));
        assertEquals("Expected hex output for large number", "7FFFFFFF", converter.convert(2147483647)); // Max int value
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertNegativeValue() {
        Dex2Hex converter = new Dex2Hex();
        converter.convert(-1); // Assuming negative input throws an exception
    }
}
