import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvSourceTest {

    @ParameterizedTest
    @CsvSource({
            "apple, 5",
            "banana, 6",
            "lemon, 5"
    })
    void testWithCsvSource(String fruit, int expectedLength) {
        assertEquals(expectedLength, fruit.length(), "The length of the fruit name should match the expected length");
    }
}