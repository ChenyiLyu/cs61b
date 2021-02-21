import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String w1 = "hooray";
        String w2 = "";
        String w3 = "b";
        String w4 = "itssnowingiwantfriedchicken";
        String w5 = "hannah";
        assertFalse(palindrome.isPalindrome(w1));
        assertTrue(palindrome.isPalindrome(w2));
        assertTrue(palindrome.isPalindrome(w3));
        assertFalse(palindrome.isPalindrome(w4));
        assertTrue(palindrome.isPalindrome(w5));
    }
}
