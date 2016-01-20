package core;

import java.util.ArrayList;

public class Graph {

	private ArrayList<Node> nodes;
	private ArrayList<Edge> edges;

	public Graph() {
		this.nodes = new ArrayList<Node>();
		this.edges = new ArrayList<Edge>();
	}

	public Graph(String node) {
		this.nodes = new ArrayList<Node>();
		this.nodes.add(new Node(node));
		this.edges = new ArrayList<Edge>();
	}

	public Graph copy() {
		Graph g = new Graph();
		for (Node n : this.nodes) {
			g.nodes.add(n.copy());
		}
		for (Edge  e : this.edges) {
			g.addEdge(e);
		}
		return g;
	}
	
	public void addNode(Node n) {
		this.nodes.add(n);
	}

	public void addNode(String name) {
		this.nodes.add(new Node(name));
	}
	
	public void addEdge(Node n1, String edge, Node n2) {
		this.edges.add(new Edge(n1, edge, n2));
	}
	
	public void addEdge(Edge e) {
		this.edges.add(e);
	}

	public Node getNode(String name) {
		for (Node n : this.nodes) {
			if (n.getName().equals(name))
				return n;
		}
		return null;
	}

	public Edge getEdge(Node n1, String edge, Node n2) {
		for (Edge e : edges) {
			if (e.getOrigin().equals(n1) && e.getTarget().equals(n2) && e.equals(edge))
				return e;
		}
		return null;
	}
	
	public ArrayList<Node> getNodes() {
		return this.nodes;
	}
	
	public boolean contains(String edge) {
		for (Edge e : this.edges) {
			if (e.equals(edge))
					return true;
		}
		return false;
	}

	public ArrayList<String> getNames() {
		ArrayList<String> names = new ArrayList<String>();
		for (Node n : nodes) {
			names.add(n.getName());
		}
		return names;
	}

	public String toString() {
		String toString = "";
		for (Node n : nodes) {
			toString += n.toString() + " ";
		}
		
		toString += "\n";
		
		for (Edge e : edges) {
			toString += e.toString() + "\n";
		}
		
		return toString;
	}

}
