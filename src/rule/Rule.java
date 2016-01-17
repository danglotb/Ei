package rule;

import java.util.ArrayList;
import java.util.HashMap;

import core.Graph;
import core.Node;

public class Rule {

	private ArrayList<Fact> facts;
	private ArrayList<String> names;
	private Fact result;

	private boolean wasApplied;
	private ArrayList<HashMap<String, String>> map;

	public Rule(String n1, String edge, String n2) {
		this.wasApplied = false;
		this.result = new Fact(n1, edge, n2);
		this.names = new ArrayList<String>();
		this.facts = new ArrayList<Fact>();
		this.map = new ArrayList<HashMap<String, String>>();
	}

	public boolean wasApplied() {
		return this.wasApplied;
	}

	public void addFact(String n1, String edge, String n2) {
		this.facts.add(new Fact(n1, edge, n2));
		if (!names.contains(n1))
			this.names.add(n1);
		if (!names.contains(n2))
			this.names.add(n2);
	}

	/**
	 * Only works for Rule with 3 and only 3 variables
	 * 
	 * @param g
	 * @return
	 */
	public Graph applyTo(Graph g) {
		this.wasApplied = false;
		for (Node n1 : g.getNodes()) {
			for (Node n2 : g.getNodes()) {
				for (Node n3 : g.getNodes()) {
					if (!n1.equals(n2) && !n1.equals(n3) && !n2.equals(n3)) {
						boolean res = true;
						int i = 0;
						HashMap<String, String> mapNames = new HashMap<String, String>();

						mapNames.put(this.names.get(0), n1.getName());
						mapNames.put(this.names.get(1), n2.getName());
						mapNames.put(this.names.get(2), n3.getName());

						while (res && i < facts.size()) {
							res &= facts.get(i).isValid(g, mapNames);
							i++;
						}

						Node z = g.getNode(mapNames.get(this.result.getN1()));
						Node x = g.getNode(mapNames.get(this.result.getN2()));
						
						if (res && x.getEdge(this.result.getEdge(), z) == null) {
							this.map.add(mapNames);
							this.wasApplied = true;
						}
					}
				}
			}
		}
		Graph newGraph = g.copy();
		for (HashMap<String, String> mapFound : this.map) {
			Node n1 = newGraph.getNode(mapFound.get(this.result.getN1()));
			Node n2 = newGraph.getNode(mapFound.get(this.result.getN2()));
			if (n1.getEdge(this.result.getEdge(), n2) == null) {
				newGraph.addEdge(mapFound.get(this.result.getN1()), this.result.getEdge(),
						mapFound.get(this.result.getN2()));
			}
		}
		return newGraph;
	}

}
