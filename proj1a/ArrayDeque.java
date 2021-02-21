
/**
 * ArrayDeque
 *
 * @auther  Chenyi Lyu 02/17/2021 debug 02/19/2021
 * @Rule:
 * note to me -
 * @refer to github
 * 1. Draw a demo to clear up logic. 难点是想清楚AD延伸的
 * 方向，运用data abstraction的思想写出plusone minusone这
 * 两个methods很重要。同时，每一个add模块分为三步：在ptr
 * 处添加item，size+1；移动ptr至下一个正确位置；check if resize；
 * remove反之亦然。
 * 2. Skeleton Array mapping to ArrayDeque.
 * 3. resize down还不知道咋做。
 *
 * 知识点：
 * generics syntax.
 * private vs. public
 * static vs. nonstatic
 *
 * the most annoying bug
 * 怎么都整不好remove/add
 *
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
        nextFirst = 7;
        nextLast = 0;
    }

/*    *//* Create an deep array copy of ArrayDeque. *//*
    public ArrayDeque(ArrayDeque other) {
        // TODO
    }*/

    /* Return the size of ArrayDeque. */
    public int size() {
        return size;
    }

    /* Add element to the front of ArrayDeque. */
    public void addFirst(T x) {
        items[nextFirst] = x;
        size += 1;
        nextFirst = minusOne(nextFirst);

        if (fillingUp()) {
            expand();
        }
    }

    /* Add element to the last of the ArrayDeque. */
    public void addLast(T x) {
        items[nextLast] = x;
        size += 1;
        nextLast = plusOne(nextLast);

        if (fillingUp()) {
            expand();
        }
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
        if (index >= size || index < 0) {
            return null;
        }
        index = plusOne(nextFirst) + index;
        if (index >= items.length) {
            index -= items.length;
        }
        return items[index];
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        int removeThis = plusOne(nextFirst);
        T removed = items[removeThis];
        items[removeThis] = null;
        size -= 1;
        nextFirst = removeThis;
        return removed;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        int removeThis = minusOne(nextLast);
        T removed = items[removeThis];
        size -= 1;
        nextLast = removeThis;
        return removed;
    }


    private boolean fillingUp() {
        return nextFirst == nextLast;
    }

    private void expand() {
        double newSize = size * 1.5;
        T[] a = (T[]) new Object[(int) newSize];
        System.arraycopy(items, 0, a, 0, nextLast);
        System.arraycopy(items, nextLast + 1, a, nextLast + (int) newSize - size, size - nextLast);
        items = a;
        nextFirst = minusOne(nextLast + (int) newSize - size);
    }

    /* plus one for input index, circle ahead to the head of array once
    * hit the tail of the array. */
    private int plusOne(int i) {
        if (i == items.length - 1) {
            return 0;
        }
        return i + 1;
    }
    /* minus one for input index, circle back to the tail of the array
    * once hit the head of the array. */
    private int minusOne(int i) {
        if (i == 0) {
            return items.length - 1;
        }
        return i - 1;
    }
}


