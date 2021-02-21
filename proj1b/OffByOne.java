/**
 * A class for off-by-1 comparators
 * */
public class OffByOne implements CharacterComparator {


    /** Return true if two characters are equal.
     * @rule Two characters are equal if they are different by exactly
     *  one. */
    @Override
    public boolean equalChars(char x, char y) {
//        if (isAlphabetic(x) && isAlphabetic(y)) {
            int diff = Math.abs((int) x - (int) y);
            if (diff == 1) {
                return true;
            }
//        }
        return false;
    }

//    private boolean isAlphabetic(char c) {
//        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
//    }

    public static void main(String[] args) {
        int x = Math.abs((int)'a'- (int)'B');
        System.out.print(x);
    }
}
