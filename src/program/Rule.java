package program;

import java.util.ArrayList;
import java.util.HashMap;

import core.Graph;
import core.Node;

public class Rule {

	private Fact result;
	private ArrayList<Fact> needs;
	private HashMap<String, ArrayList<Node>> homomorphisme;

	public Rule(Fact result) {
		this.result = result;
		this.needs = new ArrayList<Fact>();
	}

	public void addNeed(Fact fact) {
		this.needs.add(fact);
	}

	public Fact getResult() {
		return this.result;
	}

	public HashMap<String, ArrayList<Node>> computeHomomorphisme(Graph g) {
		boolean result = true;
		homomorphisme = new HashMap<String, ArrayList<Node>>();
		
		for (Fact f : this.needs) {
			HashMap<String, ArrayList<Node>> current = f.check(g, homomorphisme);
			result &= current.size() != 0;
			
			if (!result)
				return null;
			
			for (String key : current.keySet()) {
				if (! homomorphisme.containsKey(key)) 
					homomorphisme.put(key, new ArrayList<Node>());
				for (Node n : current.get(key)) {
					if (!homomorphisme.get(key).contains(n))
						homomorphisme.get(key).add(n);
				}
			}
		}
		
		return homomorphisme;
	}

}
