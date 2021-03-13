package synthesizer;
import java.util.Iterator;

/** @rules
 * items can only be enqueued at the back of the queue;
 * can onl be de dequeued from the from the front of the queue;
 * fixed capacity;
 *
 * time: March 09, 2021 1930pm-10pm 50%
 * */
public interface BoundedQueue<T> extends Iterable<T> {
    /** Return the size of the buffer. */
    int capacity();
    /** Return the items# currently in the buffer. */
    int fillCount();
    /** Add i tem to the end. */
    void enqueue(T x);
    /** Delete and return item from the front. */
    T dequeue();
    /** Return but do not delete item from the front. */
    T peek();
    /** Return True if the buffer is empty. */
    default boolean isEmpty() {
        return fillCount() == 0;
    }
    /** Return True if the buffer is full. */
    default boolean isFull() {
        return fillCount() == capacity();
    }
    /** Return an iterator. */
    Iterator<T> iterator();
}
