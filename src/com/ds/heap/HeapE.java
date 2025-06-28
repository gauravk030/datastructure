package com.ds.heap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*class BinaryTree<E>{
	List<E> elements = new ArrayList<>();
	void add(E e) {
		elements.add(e);
	}
	
	boolean isEmpty() {
		return elements.isEmpty();
	}
	
	E elementAt(int index) {
		return elements.get(index);
	}
	
	int parentIndex(int index) {
		return (index - 1) / 2;
	}
	
	int leftChildIndex(int index) {
		return (index * 2 ) + 1;
	}
	
	int rightChildIndex(int index) {
		return (index * 2 ) + 2;
	}
}*/


public class HeapE<E extends Comparable<E>> {

	List<E> elements = new ArrayList<>();
	
	public HeapE() {}
	
	boolean isEmpty() {
		return elements.isEmpty();
	}
	
	E elementAt(int index) {
		return elements.get(index);
	}
	
	int parentIndex(int index) {
		return (index - 1) / 2;
	}
	
	int leftChildIndex(int index) {
		return 2 * index + 1;
	}
	
	int rightChildIndex(int index) {
		return 2 * index + 2;
	}
	
	void add(E e) {
		elements.add(e);
		int elementIndex = elements.size() - 1;
		while(!isRoot(elementIndex) && !isCorrectChild(elementIndex)) {
			int parentIndex = parentIndex(elementIndex);
			swap(elementIndex,parentIndex);
			elementIndex = parentIndex;
		}	
	}

	boolean isRoot(int index) {
		return index == 0;
	}
	
	boolean isCorrectChild(int index) {
		return isCorrect(parentIndex(index), index);
	}
	
	boolean isCorrect(int parentIndex, int childIndex) {
		if(!isValidIndex(parentIndex) || !isValidIndex(childIndex)){
			return true;
		}
		return elementAt(parentIndex).compareTo(elementAt(childIndex)) < 0;
	}
	
	boolean isValidIndex(int index) {
		return index < elements.size();
	}
	
	void swap(int index1,int index2) {
		E element1 = elementAt(index1);
		E element2 =elementAt(index2);
		elements.set(index1, element2);
		elements.set(index2, element1);
	}
	
	E pop() {
		if(isEmpty()) {
			throw new IllegalStateException("You cannot pop from an empty heap");
		}
		E result = elementAt(0);
		
		int lastElementIndex = elements.size() - 1;
		swap(0, lastElementIndex);
		elements.remove(lastElementIndex);
		
		int elementIndex = 0;
		while (!isLeaf(elementIndex) && !isCorrectParent(elementIndex)) {
			int smallerChildIndex = smallerChildIndex(elementIndex);
			swap(elementIndex,smallerChildIndex);
			elementIndex = smallerChildIndex;
		}
		
		return result;
	}
	
	boolean isLeaf(int index) {
		return !isCorrect(index, leftChildIndex(index));
	}
	
	boolean isCorrectParent(int index) {
		return isCorrect(index, leftChildIndex(index)) && isCorrect(index, rightChildIndex(index));
	}
	
	int smallerChildIndex(int index) {
		int leftChildIndex = leftChildIndex(index);
		int rightChildIndex = rightChildIndex(index);
		
		if(!isValidIndex(rightChildIndex)) {
			return leftChildIndex;
		}
		
		if(elementAt(leftChildIndex).compareTo(elementAt(rightChildIndex)) < 0) {
			return leftChildIndex;
		}
		
		return rightChildIndex;
	}
	
	static <E extends Comparable<E>> List<E> sort(Iterable<E> elements){
		HeapE<E> heap = of(elements);
		
		List<E> result = new ArrayList<E>();
		
		while (!heap.isEmpty()) {
			result.add(heap.pop());
		}
		
		return result;
	}
	
	static <E extends Comparable<E>> HeapE<E> of(Iterable<E> elements){
		HeapE<E> result = new HeapE<>();
		for(E element : elements) {
			result.add(element);
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		List<Integer> elements1 = Arrays.asList(3,5,1,4,2);
		
		List<Integer> sortedElements = HeapE.sort(elements1);
		
		System.out.println("Sorted elements: ");
		System.out.println(sortedElements);
		
	}
}
