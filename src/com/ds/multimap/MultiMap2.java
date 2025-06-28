package com.ds.multimap;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MultiMap2<K,V> {
	private TreeMap<K,List<V>> treeMap;
	private int size;
	
	public MultiMap2() {
		this.treeMap = new TreeMap<K, List<V>>();
		this.size = 0;
	}
	
	public void put(K key,V val) {
		this.treeMap.computeIfAbsent(key,k -> new ArrayList<>()).add(val);
		this.size++;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean remove(K key,V val) {
		if(!this.treeMap.containsKey(key)) {
			return false;
		}
		if(this.treeMap.get(key).contains(val)) {
			this.size--;
			return this.treeMap.get(key).remove(val); 
		}
		return false;
	}
	
	public void removeAll(K key) {
		if(this.treeMap.containsKey(key)) 
			this.size = this.size - this.treeMap.get(key).size();
			this.treeMap.remove(key); 
	}
	
	@Override
	public String toString() {
		StringBuilder printMultiMap = new StringBuilder("{");
		printMultiMap.append("\n");
		for(K key : this.treeMap.keySet()){
			printMultiMap.append( key + " : " + treeMap.get(key) ).append(",");
			printMultiMap.append("\n");
		}
		printMultiMap.append("}");
		return printMultiMap.toString();
	}

	public static void main(String[] args) {
		MultiMap2<Character, Integer> multiMap = new MultiMap2<Character, Integer>(); 
		  
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
