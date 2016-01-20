package program;

import core.Graph;

public class Fact {

	private final String n1, n2;
	private final String edge;

	public Fact(String n1, String edge, String n2) {
		this.edge = edge;
		this.n1 = n1;
		this.n2 = n2;
	}

	public String getN1() {
		return this.n1;
	}

	public String getN2() {
		return this.n2;
	}

	public String getEdge() {
		return this.edge;
	}
	
	public boolean check(String n1, String n2, Graph g) {
		return g.getEdge(g.getNode(n1), this.edge, g.getNode(n2)) != null;
	}

}
