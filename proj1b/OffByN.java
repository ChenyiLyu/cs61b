/** A class for off-by-n comparators*/
public class OffByN implements CharacterComparator {
    private int n;  // off by n character.


    public OffByN(int N) {
        n = N;
    }

    /** Return true if two characters are equal.
     * @rule Two characters are equal if they are different by exactly
     *  n. */

    @Override
    public boolean equalChars(char x, char y) {
        int diff = Math.abs((int) x - (int) y);
        if (diff == n) {
            return true;
        }
        return false;
    }
}
