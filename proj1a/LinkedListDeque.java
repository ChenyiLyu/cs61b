/**
 * LinkedListDeque
 * @author  Chenyi 02/17/2021
 */

public class LinkedListDeque<T> {
    private class IntNode {
        public T item;
        public IntNode prev;
        public IntNode next;

        public IntNode(IntNode prevNode, T i, IntNode nextNode) {
            prev = prevNode;
            this.item = i;
            next = nextNode;
        }
    }


    private IntNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new IntNode(null, null,null); // 这里在构建IntNode时，写成一个input value更为简洁
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /* Create a deep copy of other. */
    public LinkedListDeque(LinkedListDeque<T> other) {
        sentinel = new IntNode(null, null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
        IntNode ptr = other.sentinel;
    }

    //addLast((T) other.get(i))
    //garbage 不需要recurseion//
    /** Creat a deep copy of IntNode nodes.next
    private IntNode dequeCopyHelper(LinkedListDeque other, IntNode nodes) {
        if (nodes.next == other.sentinel) {
            return sentinel;
        } else if (nodes.next.next == sentinel) {

        }
        return new IntNode(nodes, nodes.next.item, dequeCopyHelper(other, nodes.next));
    }
     */

    /* Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /* Adds an item of type T to the front of deque. */
    public void addFirst(T item) {
        sentinel.next = new IntNode(sentinel, item, sentinel.next);
        size += 1;
    }

    /* Adds an item of type T to the back of deque. */
    public void addLast(T item) {
        sentinel.prev = new IntNode(sentinel.prev, item, sentinel);
        size += 1;
    }

    /* Return true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /* Print everything in the deque. */
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.println(get(i));
        }
    }

    /* Get item at given index. */
    public T get(int index) {
        int i = 0;
        IntNode p = sentinel.next;
        while (i < index) {
            i++;
            p = p.next;
        }
        return p.item;
    }

    /* Remove and return the item in the front of deque. */
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        T removed = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return removed;
    }

    /* Remove and return the item at the last of deque. */
    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        }
        T removed = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return removed;
    }

    public T getRecursive(int index) {
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

/**
 * java generics subclass 不用再declare一遍
 * null null null
 */