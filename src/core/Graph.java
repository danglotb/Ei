package core;

import java.util.ArrayList;

public class Graph {

	private ArrayList<Node> graph;

	public Graph() {
		this.graph = new ArrayList<Node>();
	}

	public Graph(String node) {
		this.graph = new ArrayList<Node>();
		this.graph.add(new Node(node));
	}

	public Graph copy() {
		Graph g = new Graph();
		for (Node n : this.graph) {
			g.graph.add(n.copy());
		}
		return g;
	}

	public void addNode(String name) {
		this.graph.add(new Node(name));
	}
	
	public void addEdge(String n1, String path, String n2) {
		this.getNode(n1).addEdge(path, this.getNode(n2));
	}

	public Node getNode(String name) {
		for (Node n : this.graph) {
			if (n.getName().equals(name))
				return n;
		}
		return null;
	}

	public ArrayList<Node> getNodes() {
		return this.graph;
	}

	public ArrayList<String> getNames() {
		ArrayList<String> names = new ArrayList<String>();
		for (Node n : graph) {
			names.add(n.getName());
		}
		return names;
	}

	public String toString() {
		String toString = "";
		for (Node n : graph) {
			toString += n.toString() + "\n";
		}
		return toString;
	}

}
