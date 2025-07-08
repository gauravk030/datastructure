package com.sample.ds.graph;

import java.util.ArrayList;


/**
 * Input: adj =  [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]
 * 
 * 	1 ---- 2
	|    / | \
	|   /  |  \ 
	|  /   |   \
	0      3    4
	
	 
	Output: [0 1 2 3 4]
	Explanation:  The source vertex s is 0. We visit it first, then we visit an adjacent. 
	Start at 0: Mark as visited. Output: 0
	Move to 1: Mark as visited. Output: 1 
	Move to 2: Mark as visited. Output: 2 
	Move to 3: Mark as visited. Output: 3 (backtrack to 2)
	Move to 4: Mark as visited. Output: 4 (backtrack to 2, then backtrack to 1, then to 0)
	
	Not that there can be more than one DFS Traversals of a Graph. For example, after 1, we may pick adjacent 2 instead of 0 and 
	get a different DFS. 
	Example:
 * 
 *  Input: [[2,3,1], [0], [0,4], [0], [2]]
 *       0
 *     / | \
	  /  |  \ 
	2    |   \ 
	|    3    1
	|
	4          
	

	Input_undirected_Graph2
	 
	Output: [0 2 4 3 1]
	Explanation: DFS Steps:
	
	Start at 0: Mark as visited. Output: 0
	Move to 2: Mark as visited. Output: 2
	Move to 4: Mark as visited. Output: 4 (backtrack to 2, then backtrack to 0)
	Move to 3: Mark as visited. Output: 3 (backtrack to 0)
	Move to 1: Mark as visited. Output: 1 (backtrack to 0)
 * 
 */

public class DFSGraph {

	// Recursive function for DFS traversal
	private static void dfsRec(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int s, ArrayList<Integer> res) {
		visited[s] = true;
		res.add(s);

		// Recursively visit all adjacent vertices that are
		// not visited yet
		for (int i : adj.get(s)) {
			if (!visited[i]) {
				dfsRec(adj, visited, i, res);
			}
		}
	}

	// Main DFS function that initializes the visited array
	// and calls dfsRec
	public static ArrayList<Integer> DFS(ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[adj.size()];
		ArrayList<Integer> res = new ArrayList<>();
		dfsRec(adj, visited, 0, res);
		return res;
	}

	// To add an edge in an undirected graph
	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int s, int t) {
		adj.get(s).add(t);
		adj.get(t).add(s);
	}

	public static void main(String[] args) {
		int V = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		// Initialize adjacency list
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		// Add edges
		int[][] edges = { { 1, 2 }, { 1, 0 }, { 2, 0 }, { 2, 3 }, { 2, 4 } };
		for (int[] e : edges) {
			addEdge(adj, e[0], e[1]);
		}

		// Perform DFS starting from vertex 0
		ArrayList<Integer> res = DFS(adj);

		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}
	}

}
