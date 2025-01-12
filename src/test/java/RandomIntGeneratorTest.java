import prevInterviewQuestions.RandomIntGenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

class RandomIntGeneratorTest {

  private RandomIntGenerator generator;

  @BeforeEach
  void setUp() {
    // Initialize with a range of 1 to 10 for most tests
    generator = new RandomIntGenerator(1, 11);
  }

  @Test
  void testGenerateUniqueRandom_ReturnsNumbersWithinRange() {
    for (int i = 0; i < 10; i++) {
      Integer result = generator.generateUniqueRandom();
      assertNotNull(result);
      assertTrue(result >= 1 && result <= 10);
    }
  }

  @Test
  void testGenerateUniqueRandom_GeneratesAllNumbersInRange() {
    Set<Integer> generatedNumbers = new HashSet<>();
    for (int i = 0; i < 10; i++) {
      Integer result = generator.generateUniqueRandom();
      assertNotNull(result);
      generatedNumbers.add(result);
    }
    assertEquals(10, generatedNumbers.size());
  }

  @Test
  void testGenerateUniqueRandom_ReturnsNullWhenExhausted() {
    for (int i = 0; i < 10; i++) {
      assertNotNull(generator.generateUniqueRandom());
    }
    assertNull(generator.generateUniqueRandom());
  }

  @Test
  void testGenerateUniqueRandom_WithSmallerRange() {
    generator = new RandomIntGenerator(1, 6);
    Set<Integer> generatedNumbers = new HashSet<>();
    for (int i = 0; i < 5; i++) {
      Integer result = generator.generateUniqueRandom();
      assertNotNull(result);
      assertTrue(result >= 1 && result <= 5);
      generatedNumbers.add(result);
    }
    assertEquals(5, generatedNumbers.size());
    assertNull(generator.generateUniqueRandom());
  }

  @Test
  void testGenerateUniqueRandom_WithLargerRange() {
    generator = new RandomIntGenerator(1, 101);
    Set<Integer> generatedNumbers = new HashSet<>();
    for (int i = 0; i < 100; i++) {
      Integer result = generator.generateUniqueRandom();
      assertNotNull(result);
      assertTrue(result >= 1 && result <= 100);
      generatedNumbers.add(result);
    }
    assertEquals(100, generatedNumbers.size());
    assertNull(generator.generateUniqueRandom());
  }
}