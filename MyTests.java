
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * This class contains some test cases to help you write your code
 * 
 * You are encouraged to write larger test cases!
 * Note that when you submit, our tests also check that you've implementing the three
 * functions correctly (they make an appropriate number of comparisons)
 */
public class MyTests {
	private int BIGGER = 100000;
	private int BIG = 10000;
	/**
	 * Helper function for converting an array of ints to an array of our ComapreInts
	 */
	private static CompareInt[] convert(int[] arr) {
		CompareInt[] newArr = new CompareInt[arr.length];
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = new CompareInt(arr[i]);
		}
		return newArr;
	}
	
	private static CompareInt[] makeBigArray(int size) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			list.add(i + 1);
		}
		
		Collections.shuffle(list);

		int[] temp = new int[size];
		for (int i = 0; i < size; i++) {
			temp[i] = list.get(i);
		}
		
		return convert(temp);
	}
	
	
	@Test
	public void KthSmallestLargeArrayHeapTest() {
		CompareInt[] arr = makeBigArray(BIGGER);
		assertEquals(BIG, KthSmallest.heapImpl(BIG, arr));
	}
	
	@Test
	public void KthSmallestLargeArrayMergeTest() {
		CompareInt[] arr = makeBigArray(BIGGER);
		assertEquals(BIG, KthSmallest.mergeSortImpl(BIG, arr));
	}
	
	@Test
	public void KthSmallestLargeArrayQuickSelectTest() {
		CompareInt[] arr = makeBigArray(BIGGER);
		assertEquals(BIG, KthSmallest.quickSelectImpl(BIG, arr));
	}
}
