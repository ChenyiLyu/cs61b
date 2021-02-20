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

//    public static void main(String[] args) {
//        ArrayDeque ad = new ArrayDeque();
//        System.out.println(ad.get(4));
//        ad.size();
//    }

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
        if (ifResize(nextFirst)) {
            resize(nextFirst);
        }
        items[nextFirst] = x;
        size += 1;
        nextFirst -= 1;
    }

    /* Add element to the last of the ArrayDeque. */
    public void addLast(T x) {
        if (ifResize(nextFirst)) {
            resize(nextFirst);
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


    private boolean ifResize(int i) {
        return items[i] != null;
    }

    private void resize(int i) {
        double REFACTOR = 1.25;
        double newSize = size * REFACTOR;
        T[] a = (T[]) new Object[(int) newSize];
        System.arraycopy(items, 0, a, 0, i);
        System.arraycopy(items, i, a, i + (int) newSize - size, size - i);
        items = a;
        nextLast = i;
        nextFirst = i + (int) newSize - size - 1;
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

