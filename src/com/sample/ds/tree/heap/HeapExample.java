package com.sample.ds.tree.heap;

import java.util.ArrayList;
import java.util.List;

public class HeapExample {
	List<Integer> heap;
	
	public int parentNode(int i) {
		return (i - 1) / 2;
	}
	
	public int leftChild(int i) {
		return 2 * i + 1;
	}
	
	public int rightChild(int i) {
		return 2 * i + 2;
	}
	
	public HeapExample() {
		this.heap = new ArrayList<>();
	}
	
	public void swap(int i,int j) {
		int temp = heap.get(i);
		heap.set(i,heap.get(j));
		heap.set(j, temp);
	}
	
	public void insertForMin(int val) {
		heap.add(val);
		int currentIndex = heap.size() - 1;
		while(currentIndex > 0 && heap.get(currentIndex) < heap.get(parentNode(currentIndex))) {
			swap(currentIndex,parentNode(currentIndex));
			currentIndex = parentNode(currentIndex);
		}
	}
	
	public void insertForMax(int val) {
		heap.add(val);
		int currentIndex = heap.size() - 1;
		while(currentIndex > 0 && heap.get(currentIndex) > heap.get(parentNode(currentIndex))) {
			swap(currentIndex,parentNode(currentIndex));
			currentIndex = parentNode(currentIndex);
		}
	}
	
	public int extractMin() {
		if (heap.isEmpty()) {
	         throw new RuntimeException("Heap is empty");
	    }

		int min = heap.get(0);
		int lastElement = heap.remove(heap.size() - 1);
		heap.set(0, lastElement);
		int currentIndex = 0 ;
		while(true) {
			
			int leftChildIndex = leftChild(currentIndex);
			int rightChildIndex = rightChild(currentIndex);
			int smallEleIndex = currentIndex;
			
			if(leftChildIndex < heap.size() && heap.get(smallEleIndex) > heap.get(leftChildIndex)) {
				smallEleIndex = leftChildIndex;
			}
			
			if(rightChildIndex < heap.size() && heap.get(smallEleIndex) > heap.get(rightChildIndex)) {
				smallEleIndex = rightChildIndex;
			}
			
			if(smallEleIndex == currentIndex) {
				break;
			}
			
			swap(currentIndex,smallEleIndex);
			
			currentIndex = smallEleIndex;
		}
		return min;
	}
	
	public int extractMax() {
		if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
		int max = heap.get(0);
		int lastElement = heap.remove(heap.size() - 1);
		heap.set(0, lastElement);
		int currentIndex = 0;
		while (true) {
			int leftChildIndex = leftChild(currentIndex);
			int rightChildIndex = rightChild(currentIndex);
			int largeEleIndex = currentIndex;
			 
			 if(leftChildIndex < heap.size() && heap.get(largeEleIndex) < heap.get(leftChildIndex)) {
				 largeEleIndex = leftChildIndex;
			 }
			 
			 if(rightChildIndex < heap.size() && heap.get(largeEleIndex) < heap.get(rightChildIndex)) {
				 largeEleIndex = rightChildIndex;
			 }
			 
			 if(largeEleIndex ==  currentIndex) {
				 break;
			 }
			 
			 swap(currentIndex,largeEleIndex);
			 currentIndex = largeEleIndex;
		}
				
		return max;
	}
	
	public static void main(String[] args) {
		HeapExample heapExample1 = new HeapExample();

        // Insert values into the min heap
		heapExample1.insertForMin(10);
        heapExample1.insertForMin(5);
        heapExample1.insertForMin(20);
        heapExample1.insertForMin(25);
        heapExample1.insertForMin(15);
        
        System.out.println(heapExample1);
        System.out.println("Extracted Min: " + heapExample1.extractMin());
        System.out.println("Extracted Min: " + heapExample1.extractMin());
        
        HeapExample heapExample2 = new HeapExample();
        
        heapExample2.insertForMax(10);
        heapExample2.insertForMax(5);
        heapExample2.insertForMax(20);
        heapExample2.insertForMax(25);
        heapExample2.insertForMax(15);
        
        // Extract and print the maximum values from the heap
        System.out.println("Extracted Max: " + heapExample2.extractMax());
        System.out.println("Extracted Max: " + heapExample2.extractMax());

	}

}
