public class Palindrome {

    /** Put characters in word to deque. */
    public Deque<Character> wordToDeque(String word) {
        Deque wd = new LinkedListDeque();
        for (int i = 0; i < word.length(); i++) {
            wd.addLast(word.charAt(i));
        }
        return wd;
    }
    public boolean isPalindrome(String word) {
        Deque wd = wordToDeque(word);
        if (wd.size() > 10) {
            return false;
        }
        return isPalindromeHelper(wd);
    }

    public boolean isPalindromeHelper(Deque d) {
        if (d.isEmpty() || d.size() == 1) {
            return true;
        } else if (d.removeFirst() == d.removeLast()) {
            return isPalindromeHelper(d);
//            String head = (String) d.removeFirst();
//            String tail = (String) d.removeLast();
        }
        return false;

    }

    public boolean isPalindromeIteration(String word) {
        double halfLen = word.length() / 2.0;
        if (word.length() <= 0) {
            return true;
        } else if (word.length() > 10) {
            return false;
        }
        for (int i = 0, j = word.length() - 1; i < halfLen; i++, j--)
            if (word.charAt(i) != word.charAt(j)) {
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        double x = 7/2.0;
        System.out.println(x);
    }

}
