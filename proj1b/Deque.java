public interface Deque<T> {

    int size();

    void addFirst(T item);

    void addLast(T item);

    T removeFirst();

    T removeLast();

    default boolean isEmpty() {
        return size() == 0;
    };

    void printDeque();

    T get(int index);

}
