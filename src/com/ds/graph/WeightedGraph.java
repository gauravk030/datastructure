package com.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gaurav
 * @see https://www.geeksforgeeks.org/graph-implementation-using-stl-for-competitive-programming-set-2-weighted-graph/
 */
public class WeightedGraph {

	private List<List<Map<Integer,Integer>>> adj;
	private int size = 0;
	
	public WeightedGraph(int size) {
		this.size = size;
		this.adj = new ArrayList<>();
		for(int i=0; i < size; i++) {
			this.adj.add(new ArrayList<>());
		}
	}
	
	public void addEdge(int v1,int v2,int w) {
		this.adj.get(v1).add(new HashMap<Integer, Integer>());
		this.adj.get(v1).get(this.adj.get(v1).size()-1).put(v2,w);
	
		this.adj.get(v2).add(new HashMap<Integer, Integer>());
		this.adj.get(v2).get(this.adj.get(v2).size()-1).put(v1,w);
		
	}
	
	public void printGraph() {
		for(int i=0; i<size; i++ ) {
			System.out.println("\nNode " + i + " makes an edge with ");
			for(Map<Integer,Integer> map : this.adj.get(i)) {
				map.entrySet().forEach(e -> {
					System.out.println("node : "+e.getKey() + " with weight : "+e.getValue());
				});
			}
		}
	}
	
	public static void main(String[] args) {
		 int v = 5;
	        WeightedGraph obj = new WeightedGraph(v);
	        obj.addEdge(0, 1, 10);
	        obj.addEdge(0, 4, 20);
	        obj.addEdge(1, 2, 30);
	        obj.addEdge(1, 3, 40);
	        obj.addEdge(1, 4, 50);
	        obj.addEdge(2, 3, 60);
	        obj.addEdge(3, 4, 70);
	        obj.printGraph();
	}
}
