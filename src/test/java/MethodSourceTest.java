import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MethodSourceTest {

  static Stream<String> stringProvider() {
    return Stream.of("apple", "banana", "lemon");
  }

  @ParameterizedTest
  @MethodSource("stringProvider")
  void testWithMethodSource(String argument) {
    assertNotNull(argument, "The argument should not be null");
  }
}