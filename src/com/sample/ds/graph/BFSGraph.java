package com.sample.ds.graph;

import java.util.*;
import java.util.LinkedList;

/**       1  --- 3
 *     / 
 *   0    |      | 
 *     \   
 *        2 ---- 4
 * 
 * Input: adj[][] = [[1,2], [0,2,3], [0,1,4], [1,4], [2,3]]

	Breadth-First-Search-or-BFS-for-a-Graph
	 
	
	Output: [0, 1, 2, 3, 4]
	Explanation: Starting from 0, the BFS traversal will follow these steps: 
	Visit 0 → Output: [0] 
	Visit 1 (first neighbor of 0) → Output: [0, 1]
	Visit 2 (next neighbor of 0) → Output: [0, 1, 2]
	Visit 3 (next neighbor of 1) → Output: [0, 1, 2, 3]
	Visit 4 (neighbor of 2) → Final Output: [0, 1, 2, 3, 4]
	
	Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]
	
	1 ---- 2
	|    / | \
	|   /  |  \ 
	|  /   |   \
	0      3    4
	
	Output: [0, 1, 2, 3, 4]
	Explanation: Starting from 0, the BFS traversal proceeds as follows: 
	Visit 0 → Output: [0]
	Visit 1 (the first neighbor of 0) → Output: [0, 1]
	Visit 2 (the next neighbor of 0) → Output: [0, 1, 2]
	Visit 3 (the first neighbor of 2 that hasn't been visited yet) → Output: [0, 1, 2, 3]
	Visit 4 (the next neighbor of 2) → Final Output: [0, 1, 2, 3, 4]

*/
public class BFSGraph {
	
	static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
		
        int V = adj.size();
        
        int s = 0; // source node
        // create an array to store the traversal
        ArrayList<Integer> res = new ArrayList<>();
        
        // Create a queue for BFS
        java.util.Queue<Integer> q = new LinkedList<>();
        
        // Initially mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        
        // Mark source node as visited and enqueue it
        visited[s] = true;
        q.add(s);
        
        // Iterate over the queue
        while (!q.isEmpty()) {
            
            // Dequeue a vertex from queue and store it
            int curr = q.poll();
            res.add(curr);
            
            // Get all adjacent vertices of the dequeued 
            // vertex curr If an adjacent has not been 
            // visited, mark it visited and enqueue it
            for (int i : adj.get(curr)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        
        // create the adjacency list
        // {{1,2}, {0, 2, 3}, {0,4}, {1, 4}, {2,3}}
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2, 3)));       
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));       
        adj.add(new ArrayList<>(Arrays.asList(1,4)));          
        adj.add(new ArrayList<>(Arrays.asList(2,3)));          
        
        ArrayList<Integer> ans = bfs(adj);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
