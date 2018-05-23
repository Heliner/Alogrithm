package sort;

public class BinaryMergeSort {

	void merge_sort(int arr[], int l, int m, int r) {
		int help[] = new int[r - l + 1];
		int i = 0;
		int p1 = l;
		int p2 = m + 1;
		while (p1 <= m && p2 <= r)
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		while (p1 <= m)
			help[i++] = arr[p1++];
		while (p2 <= r)
			help[i++] = arr[p2++];
		for (int j = 0; j < r - l + 1; j++)
			arr[l + j] = help[j];
	}

	void merge_sort_progress(int arr[], int l, int r) {
		if (l == r)
			return;
		int mid = l + ((r - l) / 2);
		merge_sort_progress(arr, l, mid);
		merge_sort_progress(arr, mid + 1, r);
		merge_sort(arr, l, mid, r);
	}

}
