package synthesizer;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void testDeEnqueue() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        int actual;
        int expected;
        for (int i = 0; i < 10; i++) {
            arb.enqueue(i);
        }
        for (int i = 0; i < 10; i++) {
            actual = (int) arb.dequeue();
            expected = i;
            assertEquals(expected, actual);
        }

    }


    @Test
    public void testPeek() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        int actual;
        int expected;

        for (int i = 0; i < 10; i++) {
            arb.enqueue(i);
        }

        for (int i = 0; i < 10; i++) {
            actual = (int) arb.peek();
            expected = 0;
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testExample() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.isEmpty();
        arb.enqueue(9.3);
        arb.enqueue(15.1);
        arb.enqueue(31.2);
        arb.isFull();
        arb.enqueue(-3.1);
        arb.isFull();
        arb.dequeue();
        double actual = (double) arb.peek();
        double expected = 15.1;
        assertEquals(expected, actual,0.01);
    }


    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
