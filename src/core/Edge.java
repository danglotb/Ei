package core;

public class Edge {

	private Node origin;
	private String name;
	private Node target;
	
	public Edge(Node origin, String name, Node target) {
		this.origin = origin;
		this.name = name;
		this.target = target;
	}
	
	public Edge copy() {
		return new Edge(this.origin, this.name, this.target);
	}
	
	public Node getOrigin() {
		return this.origin;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Node getTarget() {
		return this.target;
	}
	
	public boolean equals(Edge that) {
		return this.name.equals(that.name) && this.target.equals(that.target) && this.origin.equals(that.origin);
	}
	
	public boolean equals(String that){
		return this.name.equals(that);
	}
	
	public String toString() {
		return this.origin + " " + this.name + " "+ this.target.getName();
	}
	
}
