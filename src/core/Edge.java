package core;

public class Edge {

	private String name;
	private Node target;
	
	public Edge(String name, Node target) {
		this.name = name;
		this.target = target;
	}
	
	public Edge copy() {
		return new Edge(this.name, this.target);
	}
	
	public String getName() {
		return this.name;
	}
	
	public Node getTarget() {
		return this.target;
	}
	
	public boolean equals(Edge that) {
		return this.name.equals(that.name) && this.target.equals(that.target);
	}
	
	public boolean equals(String that){
		return this.name.equals(that);
	}
	
	public String toString() {
		return this.name + "->" + this.target.getName();
	}
	
}
