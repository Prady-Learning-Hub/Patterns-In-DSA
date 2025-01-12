import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import twopointers.IsPalindromeValid;


class IsPalindromeValidTest {

    private IsPalindromeValid palindromeChecker;

    @BeforeEach
    void setUp() {
        palindromeChecker = new IsPalindromeValid();
    }


    @ParameterizedTest
    @CsvSource({
            "A man a plan a canal: Panama, true",
            "race a car, false",
            " , true",
            "., true",
            "a., true",
            "ab, false",
            "a, true",
            "Madam I'm Adam, true",
            "Was it a car or a cat I saw?, true",
            "Hello World!, false"
    })
    void testIsPalindrome(String input, boolean expected) {
        assertEquals(expected, palindromeChecker.isPalindrome(input));
    }

    @Test
    void testIsPalindromeWithNull() {
        assertTrue(palindromeChecker.isPalindrome(null));

    }

    @Test
    void testIsPalindromeWithEmptyString() {
        assertTrue(palindromeChecker.isPalindrome(""));
    }

    @Test
    void testIsPalindromeWithAllNonAlphanumeric() {
        assertTrue(palindromeChecker.isPalindrome("!@#$%^&*()"));
    }
}