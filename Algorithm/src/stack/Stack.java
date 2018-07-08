package stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class Stack<Item> implements Iterable<Item> {
	private int size;
	private Node<Item> first;

	private class Node<Item> {
		private Item item;
		private Node<Item> next;

		public Node(Item t) {
			this.item = t;
			this.next = null;
		}
	}

	public Stack() {
		size = 0;
		first = null;
	}

	public Stack(int max) {
		
	}

	/**
	 * push
	 * 
	 * @param t
	 */
	public void push_back(Item t) {
		Node<Item> o_first = first;
		first = new Node<Item>(t);
		first.next = o_first;
		size++;
	}

	/**
	 * pop
	 */
	public Item pop_back() {
		if (isEmpty())
			throw new NoSuchElementException("Stack is empty");
		Item t = first.item;
		first = first.next;
		size--;
		return t;

	}

	/**
	 * getSize
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
		return first.item;
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
		return new ListIterator<Item>(first);
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
	@Test
	public void test() {
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println(stack.isEmpty()?"Empty":"Not Empty");
		stack.push_back(1);
		stack.push_back(2);
		stack.push_back(3);
		stack.push_back(4);
		stack.push_back(5);
		Iterator<Integer> iterator = stack.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());;
		}
		stack.pop_back();
		stack.pop_back();
		stack.pop_back();
		stack.pop_back();
		stack.pop_back();
		System.out.println(stack.isEmpty()?"Empty":"Not Empty");
		
	}

}
