package program;

import java.util.ArrayList;
import java.util.HashMap;

import core.Graph;
import core.Node;

public class Rule {

	private Fact result;
	private ArrayList<Fact> facts;
	private ArrayList<String> variables;

	public Rule(Fact result) {
		this.result = result;
		this.facts = new ArrayList<Fact>();
		this.variables = new ArrayList<String>();
	}

	public void addNeed(Fact fact) {
		this.facts.add(fact);
		if (!this.variables.contains(fact.getN1()))
			this.variables.add(fact.getN1());
		if (!this.variables.contains(fact.getN2()))
			this.variables.add(fact.getN2());
	}

	public Fact getResult() {
		return this.result;
	}

	private static void buildSubList(ArrayList<String> values, ArrayList<String> current,
			ArrayList<ArrayList<String>> solution, int k) {
		if (current == null)
			current = new ArrayList<String>();
		for (int i = 0; i < values.size(); i++) {
			String value = values.get(i);
			values.remove(value);
			current.add(value);
			if (current.size() == k) {
				ArrayList<String> sublist = new ArrayList<String>();
				sublist.addAll(current);
				solution.add(sublist);
			}
			buildSubList(values, current, solution, k);
			values.add(i, value);
			current.remove(value);
		}
	}

	public HashMap<String, ArrayList<String>> compute(Graph g) {
		
		ArrayList<ArrayList<String>> names = new ArrayList<ArrayList<String>>();
		buildSubList(g.getNames(), null, names, this.variables.size());
		HashMap<String, ArrayList<String>> homomorphisme = new HashMap<String, ArrayList<String>>();
		
		for (ArrayList<String> map : names) {
			boolean res = true;
			for (Fact f : this.facts) {
				res &= f.check(map.get(this.variables.indexOf(f.getN1())), map.get(this.variables.indexOf(f.getN2())), g);
			}
			
			if (res) {
				for (String variable : this.variables) {
					if (!homomorphisme.containsKey(variable))
						homomorphisme.put(variable, new ArrayList<String>());
					homomorphisme.get(variable).add(map.get(this.variables.indexOf(variable)));
				}
			}
		}
		return homomorphisme;
	}

	
}
