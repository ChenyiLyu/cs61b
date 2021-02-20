/**
 * ArrayDeque
 *
 * @auther  Chenyi Lyu 02/17/2021 debug 02/19/2021
 * @Rule:
 * note to me -
 * */

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /* Create an empty array of length = 8 as default. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = -1;
        nextLast = 0;
    }

    public static <T> void main(String[] args) {
        ArrayDeque ad = new ArrayDeque();
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addFirst(3);
        ad.addFirst(4);
        ad.addFirst(5);
        ad.addFirst(6);
        ad.addFirst(7);

        ad.addFirst(8);

        ad.addFirst(9);

        ad.addFirst(5);
        ad.addFirst(10);
        T x = (T) ad.get(1);
        System.out.println(x);
        ad.size();
    }

/*    *//* Create an deep array copy of ArrayDeque. *//*
    public ArrayDeque(ArrayDeque other) {
        // TODO
    }*/

    /* Return the size of ArrayDeque. */
    public int size() {
        return size;
    }

    /* Add element to the front of ArrayDeque. */public void addFirst(T x) {
        nextFirst = checkIfSwap(nextFirst);
        if (ifResize()) {
            resize();
        }
        items[nextFirst] = x;
        size += 1;
        nextFirst -= 1;
    }

    /* Add element to the last of the ArrayDeque. */
    public void addLast(T x) {
        if (ifResize()) {
            resize();
        }
        nextLast = checkIfSwap(nextLast);
        items[nextLast] = x;
        size += 1;
        nextLast += 1;
    }

    /* Return True if ArrayDeque is empty. */
    public boolean isEmpty() {
        return size == 0;
    }

    /* Print items in order from front to last, separated by new line. */
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.println(get(i));
        }
    }

    /* Get the item in the given index. */
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        index = nextFirst + 1 + index;
        if (index >= items.length) {
            index -= items.length;
        }
        return items[index];
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        nextFirst = checkIfSwap(nextFirst);
        T temp = items[checkIfSwap(nextFirst+1)];
        items[checkIfSwap(nextFirst+1)] = null;
        size -= 1;
        nextFirst += 1;
        return temp;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        nextLast = checkIfSwap(nextLast);
        T temp = items[checkIfSwap(nextLast - 1)];
        items[checkIfSwap(nextLast - 1)] = null;
        size -= 1;
        nextLast -= 1;
        return temp;
    }


    private boolean ifResize() {
        return nextFirst == nextLast;
    }

    private void resize() {
        double REFACTOR = 1.5;
        double newSize = size + 2;
        T[] a = (T[]) new Object[(int) newSize];
        System.arraycopy(items, 0, a, 0, nextLast);
        System.arraycopy(items, nextLast + 1, a, nextLast + (int) newSize - size, size - nextLast);
        items = a;
        nextFirst = nextLast + (int) newSize - size -1;
        return;
    }

    private int checkIfSwap(int i) {
        if (i == -1) {
            return items.length - 1;
        } else if (i == items.length) {
            return 0;
        }
        return i;
    }
}

