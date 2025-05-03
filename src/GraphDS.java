
class Vertex {
	public char label;
	public boolean visited;

	public Vertex(char label) {
		this.label = label;
		visited = false;
	}
}

class Stack {
	private int size; // size of the stack
	private int[] intArray; // stack storage
	private int top; // top of the stack

	// Constructor
	public Stack(int size) {
		this.size = size;
		intArray = new int[size]; // initialize array
		top = -1; // stack is initially empty
	}

	// Operation : Push
	// push item on the top of the stack
	public void push(int data) {

		if (!isFull()) {
			// increment top by 1 and insert data
			intArray[++top] = data;
		} else {
			System.out.println("Cannot add data. Stack is full.");
		}
	}

	// Operation : Pop
	// pop item from the top of the stack
	public int pop() {
		// retrieve data and decrement the top by 1
		return intArray[top--];
	}

	// Operation : Peek
	// view the data at top of the stack
	public int peek() {
		// retrieve data from the top
		return intArray[top];
	}

	// Operation : isFull
	// return true if stack is full
	public boolean isFull() {
		return (top == size - 1);
	}

	// Operation : isEmpty
	// return true if stack is empty
	public boolean isEmpty() {
		return (top == -1);
	}
}

class Queue {

	private final int MAX;
	private int[] intArray;
	private int front;
	private int rear;
	private int itemCount;

	public Queue(int size) {
		MAX = size;
		intArray = new int[MAX];
		front = 0;
		rear = -1;
		itemCount = 0;
	}

	public void insert(int data) {
		if (!isFull()) {
			if (rear == MAX - 1) {
				rear = -1;
			}

			intArray[++rear] = data;
			itemCount++;
		}
	}

	public int remove() {
		int data = intArray[front++];
		if (front == MAX) {
			front = 0;
		}
		itemCount--;
		return data;
	}

	public int peek() {
		return intArray[front];
	}

	public boolean isEmpty() {
		return itemCount == 0;
	}

	public boolean isFull() {
		return itemCount == MAX;
	}

	public int size() {
		return itemCount;
	}
}

class Graph {
	private final int MAX = 20;
	// array of vertices
	private Vertex lstVertices[];
	// adjacency matrix
	private int adjMatrix[][];
	// vertex count
	private int vertexCount;

	private Stack stack;
	private Queue queue;

	public Graph() {
		lstVertices = new Vertex[MAX];
		adjMatrix = new int[MAX][MAX];
		vertexCount = 0;
		stack = new Stack(MAX);
		queue = new Queue(MAX);
		for (int j = 0; j < MAX; j++) // set adjacency
			for (int k = 0; k < MAX; k++) // matrix to 0
				adjMatrix[j][k] = 0;
	}

	// add vertex to the vertex list
	public void addVertex(char label) {
		lstVertices[vertexCount++] = new Vertex(label);
	}

	// add edge to edge array
	public void addEdge(int start, int end) {
		adjMatrix[start][end] = 1;
		adjMatrix[end][start] = 1;
	}

	// display the vertex
	public void displayVertex(int vertexIndex) {
		System.out.println(lstVertices[vertexIndex].label + " ");
	}

	// get the adjacent unvisited vertex
	public int getAdjUnvisitedVertex(int vertexIndex) {
		for (int i = 0; i < vertexCount; i++)
			if (adjMatrix[vertexIndex][i] == 1 && lstVertices[i].visited == false)
				return i;
		return -1;
	}

	public void depthFirstSearch() {
		// mark first node as visited
		lstVertices[0].visited = true;
		// display the vertex
		displayVertex(0);
		// push vertex index in stack
		stack.push(0);

		while (!stack.isEmpty()) {
			
			System.out.println("stack peek "+ stack.peek());
			//System.out.println(lstVertices);
			System.out.println("------------------------------");
			
			// get the unvisited vertex of vertex which is at top of the stack
			int unvisitedVertex = getAdjUnvisitedVertex(stack.peek());
			// no adjacent vertex found
			if (unvisitedVertex == -1) {
				int popVal =  stack.pop();
				System.out.println("pop val "+popVal);
			} else {
				lstVertices[unvisitedVertex].visited = true;
				System.out.println("------------------------------");
				displayVertex(unvisitedVertex);
				
				stack.push(unvisitedVertex);
			}
		}

		// stack is empty, search is complete, reset the visited flag
		for (int i = 0; i < vertexCount; i++) {
			lstVertices[i].visited = false;
		}
	}

	public void breadthFirstSearch() {
		// mark first node as visited
		lstVertices[0].visited = true;
		// display the vertex
		displayVertex(0);
		// insert vertex index in queue
		queue.insert(0);
		int unvisitedVertex;
		while (!queue.isEmpty()) {
			// get the unvisited vertex of vertex which is at front of the queue
			int tempVertex = queue.remove();
			// no adjacent vertex found
			while ((unvisitedVertex = getAdjUnvisitedVertex(tempVertex)) != -1) {
				lstVertices[unvisitedVertex].visited = true;
				displayVertex(unvisitedVertex);
				queue.insert(unvisitedVertex);
			}
		}

		// queue is empty, search is complete, reset the visited flag
		for (int i = 0; i < vertexCount; i++) {
			lstVertices[i].visited = false;
		}
	}
}

public class GraphDS {

	public static void main(String[] args) {

		Graph graph = new Graph();

		graph.addVertex('A'); // 0
		graph.addVertex('B'); // 1
		graph.addVertex('C'); // 2
		graph.addVertex('D'); // 3
		graph.addVertex('E'); // 4
		graph.addVertex('F'); // 5
		graph.addVertex('G'); // 6

		/*
		 * 1 2 3 0 |--B--C--D A--| | | 4 |-----E | 5 6 | |--F--G |--|
		 */
		graph.addEdge(0, 1); // AB
		graph.addEdge(1, 2); // BC
		graph.addEdge(2, 3); // CD
		graph.addEdge(0, 4); // AE
		graph.addEdge(0, 5); // AF
		graph.addEdge(5, 6); // FG
		System.out.print("Depth First Search: ");
		// A B C D E F G
		graph.depthFirstSearch();
		//System.out.println("");
		//System.out.print("Breadth First Search: ");
		// A B E F C G D
		//graph.breadthFirstSearch();
	}
}
