package sort;

import org.junit.Test;

public class QuickSort {
	public void quickSort(int[] a, int s, int e) {
		if (s < e) {
			int i = s, j = e;
			// 选择基准
			int key = a[s];

			while (i < j) {
				if (a[i] > a[j]) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
				if (a[i] == key) {
					j--;
				} else
					i++;
			}
			quickSort(a, s, j - 1);
			quickSort(a, j + 1, e);
			// 基准一方的游标不会变化
			// 如果大于基准向后移
			// 小于基准向前移动

		}
	}

	/**
	 * 
	 */
	/**
	 * 
	 */
	@Test
	public void Test() {
		int a[]= {1,0,2,-1,3,-4};
		this.quickSort(a, 0, a.length-1);
		for(int i =0 ;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}
}
