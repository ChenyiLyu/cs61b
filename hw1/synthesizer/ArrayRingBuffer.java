package synthesizer;

import java.util.Iterator;

public class ArrayRingBuffer<T> implements BoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;
    private int counts;
    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        counts = 0;
    }

    @Override
    public int capacity() {
        return rb.length;
    }

    @Override
    public int fillCount() {
        return counts;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring Buffer overflow");
        }
        rb[last] = x;
        counts += 1;
        last = plusOne(last);
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer underflow");
        }
        T temp = rb[first];
        rb[first] = null;
        counts -= 1;
        first = plusOne(first);
        return temp;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer underflow");
        }
        return rb[first];
    }


    private class ArrayRingBufferIterator implements Iterator<T> {
        private int pos;
        ArrayRingBufferIterator() {
            pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < capacity();
        }

        @Override
        public T next() {
            T item = rb[pos];
            pos += 1;
            return item;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

    private int plusOne(int x) {
        if (x == capacity() - 1) {
            return 0;
        }
        x += 1;
        return x;
    }


    public boolean equals(ArrayRingBuffer o) {
        Iterator thisIterator = this.iterator();
        Iterator oIterator = o.iterator();
        for (int i = 0; i < capacity(); i++) {
            if (thisIterator.next() != oIterator.next()) {
                return false;
            }
        }
        return true;
    }


}
