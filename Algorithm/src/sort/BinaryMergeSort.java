package sort;

public class BinaryMergeSort {

	void merge_sort(int arr[], int L, int m, int r) {
		int help[] = new int[r - L + 1];
		int i = 0;
		int p1 = L;
		int p2 = m + 1;
		while (p1 <= m && p2 <= r)
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		while (p1 <= m)
			help[i++] = arr[p1++];
		while (p2 <= r)
			help[i++] = arr[p2++];
		for (int j = 0; j < r - L + 1; j++)
			arr[L + j] = help[j];
	}

	void merge_sort_progress(int arr[], int L, int r) {
		if (L == r)
			return;
		int mid = L + ((r - L) / 2);
		merge_sort_progress(arr, L, mid);
		merge_sort_progress(arr, mid + 1, r);
		merge_sort(arr, L, mid, r);
	}

}
