import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvFileSourceTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void testWithCsvFileSource(String fruit, int expectedLength) {
        assertEquals(expectedLength, fruit.length(), "The length of the fruit name should match the expected length");
    }
}