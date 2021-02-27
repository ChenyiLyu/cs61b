import static org.junit.Assert.*;
import org.junit.Test;

/** A single JUnit test to test out StudentArrayDeque the addFirst, addLast, removeFirst,
 *  and removeLast methods. */

public class TestArrayDequeGold {
    private String message = "\n";
    private String operation;
    private static int randomTestRounds = 1000;
    /** @rule Test should randomly call StudentArrayDeque and ArrayDequeSolution.*/
    @Test
    public void testAddRemove() {
        StudentArrayDeque<Integer> sAD = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> mAD = new ArrayDequeSolution<>();
        for (int i = 0; i < randomTestRounds; i++) {
            double seed = StdRandom.uniform();
            if (seed < 0.25 | sAD.isEmpty() | sAD.isEmpty()) {
                operation = "addFirst("+ i +")";
                sAD.addFirst(i); mAD.addFirst(i);
            } else if (seed < 0.5) {
                operation = "addLast("+ i +")";
                sAD.addLast(i); mAD.addLast(i);
            } else if (seed < 0.75) {
                Integer s = sAD.removeFirst(); Integer m = mAD.removeFirst();
                assertEquals(message + "removeFirst(): "+ i, m, s);
                operation = "removeFirst(): "+ i);
            } else {
                Integer s = sAD.removeLast(); Integer m = mAD.removeLast();
                assertEquals(message + "removeLast(): "+ i, m, s);
                operation = "removeLast(): "+ i);
            }
            message += operation + "\n";

        }
    }


}
