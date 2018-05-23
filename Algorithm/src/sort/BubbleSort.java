package sort;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class BubbleSort {

	List<Integer> list;

	public void initial() {
		// 输入
		list = new LinkedList();
		list.add(1);
		list.add(8);
		list.add(10);
		list.add(7);
		list.add(3);
	}

	public void bubbleSort() {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size()-1 - i; j++) {
				if (list.get(j) < list.get(j + 1)) {
					int temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	@Test
	public void Test() {
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.initial();
		bubbleSort.bubbleSort();
	}
}
