package core;

public class Node {
	
	private String name;
	
	public Node(String name) { 
		this.name = name;
	}
	
	public Node copy() {
		return new Node(this.name);
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean equals(Node that) {
		return this.name == that.name;
	}
	
	public String toString() {
		return this.name + "\t";
	}

}
	