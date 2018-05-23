package sort;

import org.junit.Test;

public class SelectionSort {

	void selsectSort(int a[], int s, int e) {
		int min_idex;
		for (int i = 0; i < a.length - 1; i++) {
			min_idex = i;
			for (int j = i + 1; j < a.length - 1; j++) {
				if (a[j] < a[min_idex]) {
					min_idex = j;
				}
			}

			int min = a[min_idex];
			a[min_idex] = a[i];
			a[i] = min;
		}
	}

	@Test
	public void Test() {
		int a[] = { -1, 2, 4, 0, 2, 1 };
		this.selsectSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length - 1; i++) {
			System.out.println(a[i]);
		}
	}

}
