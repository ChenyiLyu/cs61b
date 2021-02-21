/**
 * A class for off-by-1 comparators
 * */
public class OffByOne implements CharacterComparator {


    /** Return true if two characters are equal.
     * @rule Two characters are equal if they are different by exactly
     *  one. */
    @Override
    public boolean equalChars(char x, char y) {
        int diff = Math.abs((int) x - (int) y);
        if (diff == 1) {
            return true;
        }
        return false;
    }

}
