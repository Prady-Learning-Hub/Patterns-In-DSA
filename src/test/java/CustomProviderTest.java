import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class CustomProviderTest {

  @ParameterizedTest
  @ArgumentsSource(CustomArgumentsProvider.class)
  void testWithCustomProvider(String argument) {
    assertNotNull(argument, "The argument should not be null");
  }

  static class CustomArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of("apple", "banana", "lemon").map(Arguments::of);
    }
  }
}