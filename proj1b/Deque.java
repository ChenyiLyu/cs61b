public interface Deque<T> {

    public int size();

    public void addFirst(T item);

    public void addLast(T item);

    public T removeFirst();

    public T removeLast();

    default public boolean isEmpty() {
        return size() == 0;
    };

    public void printDeque();

    public T get(int index);

}
