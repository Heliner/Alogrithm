package sort;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class InsertionSort {
	void Insertsort1(int a[], int n) {
		int i, j, k;
		for (i = 1; i < n; i++) {
			// 为a[i]在前面的a[0...i-1]有序区间中找一个合适的位置
			for (j = i - 1; j >= 0; j--)
				if (a[j] < a[i])
					break;
			// 如找到了一个合适的位置
			if (j != i - 1) {
				// 将比a[i]大的数据向后移
				int temp = a[i];
				for (k = i - 1; k > j; k--)
					a[k + 1] = a[k];
				// 将a[i]放到正确位置上
				a[k + 1] = temp;
			}
		}
		for (i = 1; i < n; i++) {
			System.out.println(a[i]);
		}
	}

	@Test
	public void Test() {
		int a[] = { -99999, -1, 0, 2, 6, 1, 7, 2 };
		this.Insertsort1(a, a.length);
	}
}
