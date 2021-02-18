public class ArrayDeque<T> {
    T[] items;
    int size;
    int nextFirst;
    int nextLast;


    public ArrayDeque() {
        T[] items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    /* Return the size of ArrayDeque. */
    public int size() {
        return size;
    }

    /* Add element to the front of ArrayDeque. */
    public void addFirst(T x) {
        nextFirst = checkIfSwap(nextFirst);
        resize(nextFirst);
        items[nextFirst] = x;
        size += 1;
        nextFirst -= 1;
    }

    public void addLast(T x) {
        nextLast = checkIfSwap(nextLast);
        items[nextLast] = x;
        size +=1;
        nextLast += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        if (nextFirst < nextLast) {
            T[] tempA = (T[]) new Object[nextLast - nextFirst - 1];
            System.arraycopy(items, nextFirst+1, tempA, 0, tempA.length);
            for (T element : tempA) {
                System.out.println(element);
            }
        } else {
            for (int i = nextFirst + 1; i < items.length; i++) {
                System.out.println(items[i]);
            }
            for (int i = 0; i < nextLast; i++) {
                System.out.println(items[i]);
            }
        }

    }

    public T get(int index) {
        return items[index];
    }

    public T removeFirst() {
        nextFirst = checkIfSwap(nextFirst);
        T temp = items[nextFirst + 1];
        items[nextFirst + 1] = null;
        size -= 1;
        nextFirst +=1;
        return temp;
    }

    public T removeLast() {
        nextLast = checkIfSwap(nextLast);
        T temp = items[nextLast + 1];
        items[nextLast - 1] = null;
        size -= 1;
        nextLast -= 1;
        return temp;
    }

    private void resize(int i) {
        if (items[i] != null) {
            T[] a = (T[]) new Object[items.length + 1];
            System.arraycopy(items, 0, a, 0, i);
            System.arraycopy(items, i + 1, a, i + 2, size - i);
            items = a;
            return;
        }
        return;
    }

    private int checkIfSwap(int i) {
        if (i == -1) {
            return items.length - 1;
        } else if (i == items.length) {
            return 0;
        };
        return i;
    }
}
