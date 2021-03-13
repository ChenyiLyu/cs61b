package synthesizer;


public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {

    protected int capacity;
    protected int fillCount;

    /** Return the size of the buffer. */
    @Override
    public int capacity() {
        return capacity;
    }

    /** Return the items# currently in the buffer. */
    @Override
    public int fillCount() {
        return fillCount;
    }
}

