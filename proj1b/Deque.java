/** Deque Interface*/
public interface Deque<T> {

    /** Return the number of items in the deque. */
    int size();

    /** Add an item of type T to the front of the deque. */
    void addFirst(T item);

    /** Add an item of type T to the back of the deque. */
    void addLast(T item);

    /** Remove and return the first item in the deque.
     * Return null if no such item exits.
     * */
    T removeFirst();

    /** Remove and return the last item in the deque.
     * Return null if no such item exits.
     * */
    T removeLast();


    /** Return null if the deque is empty. Otherwise, return true. */
    default boolean isEmpty() {
        return size() == 0;
    };

    /** Print the items in order. */
    void printDeque();

    /** Return the item at the given index in the deque. */
    T get(int index);

}
