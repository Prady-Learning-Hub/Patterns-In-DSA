import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class EnumSourceTest {

  @ParameterizedTest
  @EnumSource(Fruit.class)
  void testWithEnumSource(Fruit fruit) {
    assertTrue(fruit.name().length() > 4, "The length of the enum name should be greater than 4");
  }

  enum Fruit {
    APPLE, BANANA, LEMON
  }
}