package program;

import java.util.ArrayList;
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

	public String getEdge() {
		return this.edge;
	}

	public HashMap<String, ArrayList<Node>> check(Graph g, HashMap<String, ArrayList<Node>> h) {
		ArrayList<String> names = g.getNames();
		if (!h.containsKey(this.n1))
			h.put(this.n1, new ArrayList<Node>());
		if (!h.containsKey(this.n2))
			h.put(this.n2, new ArrayList<Node>());
		for (int i = 0 ; i < names.size() ; i++) {
			for (int j = 0 ; j < names.size() ; j++) {
				if (i != j) {
					if (g.getEdge(g.getNode(names.get(i)), this.edge, g.getNode(names.get(i))) != null) {
						
					}
				}
			}
		}
		for (String s1 : names) {
			for (String s2 : names) {
				if (!s1.equals(s2)) {
					if (g.getEdge(g.getNode(s1), this.edge, g.getNode(s2)) != null) {
						boolean b1 = false, b2 = false;
						for (String key : h.keySet()) {
							try {
								b1 |= h.get(key).get(names.indexOf(s1)).equals(g.getNode(s1));
							} catch (Exception e) {}
							try {
								b2 |= h.get(key).get(names.indexOf(s2)).equals(g.getNode(s2));
							} catch (Exception e) {}
						}
						
						if (!b1 && !b2) {
							h.get(this.n1).add(g.getNode(s1));
							h.get(this.n2).add(g.getNode(s2));
						}
					}
				}
			}
		}

		return h;
	}

}
