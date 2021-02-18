public class SLList {
	private IntNode sentinel;
	/* create a cache but speed up! */
	private int size;
	/* last pointer */
	private IntNode last;




	public SLList(int x) {
		sentinel = new IntNode(211, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}

	/* add an item to the front. */
	public void addFirst(int x) {
		sentinel.next = new IntNode(x, sentinel.next);
		size += 1;
	}

	/* get the front item in the list*/
	public int getFirst() {
		return sentinel.next.item;
	}

	/* add an item to the last. */
	public addLast(int x) {
		IntNode p = sentinel;
		while (p.next != null) {
			p = p.next;
		}
		p.next = new IntNode(x, null);
		size += 1;

		last = p.next;
	}

	/* size */
	public int size() {
		return size;
	}


	private static class IntNode {
		private int item;
		private IntNode prev;
		private IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
		}
	}

	public static void main(String[] args) {
	}



}

// 在写methods的时候，面对的是经由constructor的instance，想想怎么给它增加functionality？fiel
// resize 可以return void
// data abstraction is easy to maintain and illustrate idea, especially, test. So define a new method if you can