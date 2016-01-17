package core;
import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private String name;
	private ArrayList<Edge> edges;
	
	public Node(String name) { 
		this.name = name;
		this.edges = new ArrayList<Edge>();
	}
	
	public Node copy() {
		Node clone = new Node(this.name);
		
		for (Edge e : edges) {
			clone.edges.add(e.copy());
		}
		
		return clone;
	}
	
	public void addEdge(String name, Node node) {
		this.edges.add(new Edge(name,node));
		node.edges.add(new Edge(name,this));
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean contains(String edge) {
		for (Edge e : edges){
			if (e.equals(edge))
				return true;
		}
		return false;
	}
	
	public Edge getEdge(String name, Node n2) {
		for (Edge e : this.edges) {
			if (e.getName().equals(name) && e.getTarget().equals(n2))
				return e;
		}
		return null;
	}
	
	public List<Edge> getEdges() {
		return this.edges;
	}
	
	public boolean equals(Node that) {
		return this.name == that.name;
	}
	
	public String toString() {
		String toString = this.name + "\t";
		for (Edge e :edges) {
			toString += e.toString() + " "; 
		}
		return toString;
	}

}
	