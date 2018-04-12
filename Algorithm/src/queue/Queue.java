package queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
	private int size;
	private Node<Item> front;
	private Node<Item> rear;

	private class Node<Item> {
		private Item item;
		private Node<Item> next;

		public Node(Item t) {
			this.item = t;
			this.next = null;
		}

		public Node() {
			this.item = null;
			this.next = null;
		}
	}

	public Queue() {
		size = 0;
		front = new Node<Item>();
		rear = front;
	}

	/**
	 * 
	 * insert
	 * 
	 * @param t
	 */
	public void insert(Item t) {
		Node<Item> n_node = new Node<Item>(t);
		if (size == 0)
			front = n_node;

		rear.next = n_node;
		rear = n_node;
		size++;
	}

	/**
	 * deQueue
	 */
	public Item deQueue() {
		if (isEmpty())
			throw new NoSuchElementException("Stack is empty");
		Item t = front.item;
		front = front.next;
		size--;
		return t;
	}

	/**
	 * retrun this queue's Size
	 * 
	 * @return
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Empty?
	 */
	public boolean isEmpty() {
		if (size <= 0)
			return true;
		return false;
	}

	/**
	 * top element
	 */
	public Item peek() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		return front.item;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Item item : this)
			s.append(item + " ");
		return s.toString();
	}

	/**
	 * Returns an iterator to this stack that iterates through the items in LIFO
	 * order.
	 * 
	 * @return an iterator to this stack that iterates through the items in LIFO
	 *         order.
	 */
	public Iterator<Item> iterator() {
		return new ListIterator<Item>(front);
	}

	// an iterator, doesn't implement remove() since it's optional
	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;

		public ListIterator(Node<Item> first) {
			current = first;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

}
