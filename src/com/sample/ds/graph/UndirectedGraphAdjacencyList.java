package com.sample.ds.graph;

import java.util.ArrayList;
import java.util.List;


/**
 * Undirected graph has 3 vertices. So, an array of list will be created of size 3, where each indices represent the vertices. 
 * Now, vertex 0 has two neighbours (i.e, 1 and 2). So, insert vertex 1 and 2 at indices 0 of array. 
 * Similarly, For vertex 1, it has two neighbour (i.e, 2 and 0) So, insert vertices 2 and 0 at indices 1 of array. 
 * Similarly, for vertex 2, insert its neighbours in array of list.
 * 
 * Matrix ->
 *       0  1  2
 *  0  { 0, 1, 1 },
    1  { 1, 0, 1 },
    2  { 1, 1, 0 },
 * 
 * O/P ->
 * Adjacency List Representation:	
		0: 1 2 
		1: 0 2 
		2: 0 1  
		
 */
public class UndirectedGraphAdjacencyList {

    // Method to add an edge between two vertices
    public static void addEdge(List<List<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i); // Undirected
    }

    // Method to display the adjacency list
    public static void displayAdjList(List<List<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + ": "); // Print the vertex
            for (int j : adj.get(i)) {
                System.out.print(j + " "); // Print its adjacent 
            }
            System.out.println(); 
        }
    }

    // Main method
    public static void main(String[] args) {
      
        // Create a graph with 3 vertices and no edges
        int V = 3;
        List<List<Integer>> adj = new ArrayList<>(V); 
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Now add edges one by one
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);

        System.out.println("Adjacency List Representation:");
        displayAdjList(adj);
    }
	
}
