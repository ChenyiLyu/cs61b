import static org.junit.Assert.*;
import org.junit.Test;

/** A single JUnit test to test out StudentArrayDeque the addFirst, addLast, removeFirst,
 *  and removeLast methods. */

public class TestArrayDequeGold {

    /** @rule Test should randomly call StudentArrayDeque and ArrayDequeSolution.*/
    @Test
    public void testAddRemove() {
        StudentArrayDeque<Integer> sAD = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> mAD = new ArrayDequeSolution<>();
        for (int i = 0; i < 20; i++) {

            double seed = StdRandom.uniform();
            if (seed < 0.25 | (sAD.isEmpty() && mAD.isEmpty())) {
                System.out.println('1');
                sAD.addFirst(i); mAD.addFirst(i);
            } else if (seed < 0.5) {
                System.out.println('2');
                sAD.addLast(i); mAD.addLast(i);
            } else if (seed < 0.75) {
                System.out.println('3');
                Integer s = sAD.removeFirst();
                Integer m = mAD.removeFirst();
                assertEquals(m, s);
            } else {
                System.out.println('4');
                Integer s = sAD.removeLast();
                Integer m = mAD.removeLast();
                assertEquals(m, s);
            }
        }
    }





}
