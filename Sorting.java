import java.util.Arrays;

public class Sorting {
	
	/**
	 * Implement the mergesort function, which should sort the array of
	 * integers in place
	 * 
	 * You will probably want to use helper functions here, as described in the lecture recordings
	 * (ex. merge(), a helper mergesort function)
	 * @param arr
	 */
	public static void mergeSort(CompareInt[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}
	
	private static void mergeSort(CompareInt[] arr, int left, int right) {
		if (right - left <= 0)  return;
		
		int mid = (left + right) / 2;	
		
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		
		CompareInt[] a = Arrays.copyOfRange(arr, left, mid + 1);
		CompareInt[] b = Arrays.copyOfRange(arr, mid + 1, right + 1);
		
		CompareInt[] temp = merge(a, b);
		
		for (int i = left; i < right + 1; i++) {
			arr[i] = temp[i - left];
		}
		
	}
	
	private static CompareInt[] merge(CompareInt[] a, CompareInt[] b) {
		CompareInt[] c = new CompareInt[a.length + b.length];
		
		int i = 0;
		int j = 0;
		int k = 0;
		
        while (i < a.length && j < b.length) {
            if (a[i].compareTo(b[j]) < 0) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;
            }
            k++;
        }
        
        while (i < a.length) {
            c[k++] = a[i++];
        }

        while (j < b.length) {
            c[k++] = b[j++];
        } 
        
        return c;
	}
	
	/**
	 * Implement the quickSelect
	 * 
	 * Again, you will probably want to use helper functions here
	 * (ex. partition(), a helper quickselect function)
	 */
	public static CompareInt quickSelect(int k, CompareInt[] arr) {
		return quickSelect(k - 1, arr, 0, arr.length - 1);
	}
	
	private static CompareInt quickSelect(int k, CompareInt[] arr, int left, int right) {
		if (left == right) {
			return arr[left];
		}

		int pivotIndex = partition(arr, left, right);
		
		if (k == pivotIndex) {
			return arr[pivotIndex];
		} else if (k < pivotIndex) {
			return quickSelect(k, arr, left, pivotIndex - 1);
		} else {
			return quickSelect(k, arr, pivotIndex + 1, right);
		}
	}
	
	private static int partition(CompareInt[] arr, int left, int right) {
		int pivotIndex = left + (int) Math.floor(Math.random() * (right - left + 1));
		CompareInt pivotValue = arr[pivotIndex];
		
		swap(arr, pivotIndex, right);
	
		int partitionIndex = left;

		for (int i = left; i < right; i++) {
			if (arr[i].compareTo(pivotValue) < 0) {
				swap(arr, partitionIndex, i);
				partitionIndex++;
			}
		}

		swap(arr, right, partitionIndex);
		
		return partitionIndex;
	}
	
	private static <T> void swap(T[] arr, int i, int j) {
		T temp  = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
