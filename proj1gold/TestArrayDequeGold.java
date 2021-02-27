import static org.junit.Assert.*;
import org.junit.Test;

/** A single JUnit test to test out StudentArrayDeque the addFirst, addLast, removeFirst,
 *  and removeLast methods. */

public class TestArrayDequeGold {

    /** @rule Test should randomly call StudentArrayDeque and ArrayDequeSolution.*/
    @Test
    public void testAddRemove() {    StudentArrayDeque<Integer> sAD = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> mAD = new ArrayDequeSolution<>();
        int i = 3;
        sAD.addFirst(i); mAD.addFirst(i);
        sAD.addFirst(i); mAD.addFirst(i);
        Integer s1 = sAD.removeFirst(); Integer m1 = mAD.removeFirst();
        sAD.addFirst(i); mAD.addFirst(i);
        sAD.addLast(i); mAD.addLast(i);
        sAD.addLast(i); mAD.addLast(i);
        sAD.addFirst(i); mAD.addFirst(i);
        sAD.addFirst(i); mAD.addFirst(i);
        sAD.addLast(i); mAD.addLast(i);
        Integer s2 = sAD.removeLast();Integer m2 = mAD.removeLast();
        Integer s3 = sAD.removeLast();Integer m3 = mAD.removeLast();
        assertEquals(m3, s3);
    }





}
