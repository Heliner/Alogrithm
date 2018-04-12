package queue;

import java.util.Iterator;

import org.junit.Test;

public class TestQueue {
	@Test
	public void show(){
		Queue<Integer> queue = new Queue<Integer>();
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);
		queue.insert(5);
		queue.insert(6);
		System.out.println("This are all elements this queue has:");
		Iterator iterator = queue.iterator();
		while(iterator.hasNext()){
			System.out.println("element:"+iterator.next());
		}
		System.out.println("This is peek !");
		System.out.println(queue.peek());
		System.out.println("This is Size");
		System.out.println(queue.size());
		System.out.println("The deQueue's element");
		System.out.println(queue.deQueue());
		System.out.println("this is Size");
		System.out.println(queue.size());
	}
	
}
