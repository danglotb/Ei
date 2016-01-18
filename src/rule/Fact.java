package rule;

import java.util.HashMap;

import core.Graph;
import core.Node;

public class Fact {
	
	private String n1, n2;
	private String edge;
	
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
	
	public HashMap<String,Node> check(Graph g) {
		return new HashMap<String,Node>();
	}
	
	public boolean isValid(Graph g, HashMap<String,Node> names) {
		return false;
	}
	
	
	public String getEdge() {
		return this.edge;
	}
	
}
