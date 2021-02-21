/**
 * Class helps to identify generalized Palindromes in English.
 * @author Chenyi 2/21/2021
 * */

public class Palindrome {

    /** Put characters in word to deque. */
    public Deque<Character> wordToDeque(String word) {
        Deque wd = new LinkedListDeque();
        for (int i = 0; i < word.length(); i++) {
            wd.addLast(word.charAt(i));
        }
        return wd;
    }

    /** Determine if a word is palindrome recursively. */
    public boolean isPalindrome(String word) {
        Deque wd = wordToDeque(word);
        return isPalindromeHelper(wd);
    }

    private boolean isPalindromeHelper(Deque d) {
        if (d.isEmpty() || d.size() == 1) {
            return true;
        } else if (d.removeFirst() == d.removeLast()) {
            return isPalindromeHelper(d);
        }
        return false;

    }

    /** Determine if a word is palindrome iteratively. */
    private boolean isPalindromeIteration(String word) {
        double halfLen = word.length() / 2.0;
        if (word.length() <= 0) {
            return true;
        }
        for (int i = 0, j = word.length() - 1; i < halfLen; i++, j--) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    /** A third public method to return true if a word is off-by-one
     * palindrome. */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque wd = wordToDeque(word);
        return isPalindromeHelper(wd, cc);
    }

    private boolean isPalindromeHelper(Deque d, CharacterComparator cc) {
        if (d.isEmpty() || d.size() == 1) {
            return true;
        } else if (cc.equalChars((char) d.removeFirst(), (char) d.removeLast())) {
            return isPalindromeHelper(d, cc);
        }
        return false;
    }

}
