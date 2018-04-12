package stack;

import java.util.Iterator;

import org.junit.Test;

public class TestStack {
	@Test
	public void show() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push_back(1);
		stack.push_back(2);
		stack.push_back(3);
		stack.push_back(4);
		stack.push_back(5);
		Iterator<Integer> iterator = stack.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());;
		}
		
	}
}
