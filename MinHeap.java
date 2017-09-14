

/**
 * A Heap implementation class
 * 
 * @param heap the array that holds the heap data
 * @param size the number of elements currently stored in the heap
 */
public class MinHeap {
	
	CompareInt[] heap;
	int size;
	private static final int FIRST = 1;

	/**
	 * Constructs a new heap with maximum capacity n
	 * Remember to index your heap at 1 instead of 0!
	 * @param n the maximum number of elements allowed in the heap
	 */
	public MinHeap(int n) {
		heap = new CompareInt[n+1];
		size = 0;
	}
	
	/**
	 * Adds an element to the heap
	 * 
	 * @param val the value to be added to the heap
	 */
	public void add(CompareInt val) {
		heap[++size] = val;
		int current = size;
		int parent  = parent(current);
		
		while (parent != 0 && heap[current].compareTo(heap[parent]) < 0) {
			swap(current, parent);
			current = parent(current);
			parent = parent(current);
		}

	}
	
	/**
	 * Extracts the smallest element from the heap
	 */
	public CompareInt extractMin() {
		CompareInt result = heap[FIRST];
		heap[FIRST] = heap[size--];
		minHeapify(FIRST);
		return result;
	}
	
	private void minHeapify(int pos) {
		if (isLeaf(pos))  return;
		int left  = leftChild(pos);
		int right = rightChild(pos);
		
		if (heap[pos].compareTo(heap[left]) > 0 || heap[pos].compareTo(heap[right]) > 0) {
			if (heap[left].compareTo(heap[right]) < 0) {
				swap(pos, left);
				minHeapify(left);
			} else {
				swap(pos, right);
				minHeapify(right);					
			}
		}
	}
	
	
	private int parent(int pos) {
		return pos / 2;
	}
	
	private int leftChild(int pos) {
		return 2 * pos;
	}
	
	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}
	
	private boolean isLeaf(int pos) {
		return pos >= (size / 2) && pos <= size;
	}
	
	private void swap(int a, int b) {
		CompareInt temp  = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
}
