import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnumSourceTest {

    enum Fruit {
        APPLE, BANANA, LEMON
    }

    @ParameterizedTest
    @EnumSource(Fruit.class)
    void testWithEnumSource(Fruit fruit) {
        assertTrue(fruit.name().length() > 4, "The length of the enum name should be greater than 4");
    }
}