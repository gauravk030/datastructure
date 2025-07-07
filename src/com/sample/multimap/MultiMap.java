package com.sample.multimap;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MultiMap<K,V> {
	private TreeMap<K, List<V>> treeMap;
	private int size;
	
	public MultiMap() {
		treeMap = new TreeMap<>();
		size = 0;
	}
	
	private int size() {
		return size;
	}
	
	public void put(K key ,V val) {
		treeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
		size++;
	}
	
	public boolean containsKey(K key) {
		return treeMap.containsKey(key);
	}
	
	public boolean containsValues(K key) {
		return treeMap.containsKey(key);
	}
	
	public boolean remove(K key,V val) {
		boolean isKeyPresent = containsKey(key);
		if(!isKeyPresent) {
			return false;
		}
		boolean isValPresent = treeMap.get(key).contains(val);
		if(isValPresent) {
			treeMap.get(key).remove(val);
			size--;
		}
		return true;
	}
	
	public List<V> get(K key) {
		return containsKey(key)? treeMap.get(key): new ArrayList<>();
	}
	
	public void removeAll(K key) {
		if(containsKey(key)) {
			size = size - treeMap.get(key).size();
			treeMap.remove(key);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder printMultiMap = new StringBuilder("{");
		for(K key : treeMap.keySet()) {
			
			printMultiMap.append("{").append("key: ").append(key).append(",")
						 .append("val:").append(treeMap.get(key)).append("}").append(" , ");
		}
		printMultiMap.append("}");
		return printMultiMap.toString();
	}
	
	public static void main(String[] args) {
		MultiMap<Character, Integer> multiMap = new MultiMap<>(); 
		  
        // adding values in multimap 
        multiMap.put('A', 1); 
        multiMap.put('B', 2); 
        multiMap.put('C', 3); 
        multiMap.put('A', 4); 
        multiMap.put('B', 5); 
        multiMap.put('A', 6); 
        multiMap.put('D', 7); 
        multiMap.put('D', 8); 
        
        System.out.println(multiMap);
        System.out.println("Size "+ multiMap.size());
        
        // Remove specific key-value pair 
        multiMap.remove('A', 4); 
  
        // MultiMap After performing remove operations 
        System.out.println("\nAfter performing remove operation"); 
        System.out.println("The Key and values in the MultiMap are: "); 
        System.out.println(multiMap); 
        System.out.println("\nSize Of multiMap : " + multiMap.size()); 
        
        // Remove all
        multiMap.removeAll('D');
  
        // MultiMap After performing remove operations 
        System.out.println("\nAfter performing remove operation"); 
        System.out.println("The Key and values in the MultiMap are: "); 
        System.out.println(multiMap); 
        System.out.println("\nSize Of multiMap : " + multiMap.size()); 
	}
}
