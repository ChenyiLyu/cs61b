/**
 * LinkedListDeque
 * @author  Chenyi 02/20/2021
 * Sequence linked list that can be extended/contracted from both ends.
 */

public class LinkedListDeque<T> implements Deque<T> {
    private class IntNode {
        private T item;
        private IntNode prev;
        private IntNode next;

        IntNode(IntNode prevNode, T i, IntNode nextNode) {
            prev = prevNode;
            this.item = i;
            next = nextNode;
        }
    }

    private IntNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null); // 这里在构建IntNode时，写成一个input value更为简洁
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(T item) {
        sentinel.next = new IntNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }
    @Override
    public void addLast(T item) {
        sentinel.prev = new IntNode(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.println(get(i));
        }
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int i = 0;
        IntNode p = sentinel.next;
        while (i < index) {
            i++;
            p = p.next;
        }
        return p.item;
    }

    @Override
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        T removed = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return removed;
    }

    @Override
    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        }
        T removed = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return removed;
    }

    /* Recursion vision of get method. */
    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecurHelper(index, sentinel.next);
    }

    private T getRecurHelper(int index, IntNode lst) {
        if (index == 0) {
            return lst.item;
        } else {
            return getRecurHelper(index - 1, lst.next);
        }
    }

}
