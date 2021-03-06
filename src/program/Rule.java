package program;

import java.util.ArrayList;
import java.util.HashMap;

import core.Edge;
import core.Graph;

public class Rule {

	private Fact result;
	private ArrayList<Fact> facts;
	private ArrayList<String> variables;

	public Rule(Fact result) {
		this.result = result;
		this.facts = new ArrayList<Fact>();
		this.variables = new ArrayList<String>();
		if (!this.variables.contains(result.getN1()))
			this.variables.add(result.getN1());
		if (!this.variables.contains(result.getN2()))
			this.variables.add(result.getN2());
	}

	public void addFact(Fact fact) {
		this.facts.add(fact);
		if (!this.variables.contains(fact.getN1()))
			this.variables.add(fact.getN1());
		if (!this.variables.contains(fact.getN2()))
			this.variables.add(fact.getN2());
	}
	
	public void addFact(String n1, String edge, String n2) {
		this.facts.add(new Fact(n1, edge, n2));
		if (!this.variables.contains(n1))
			this.variables.add(n1);
		if (!this.variables.contains(n2))
			this.variables.add(n2);
	}
	
	public boolean isInitial(Graph g) {
		boolean res = true;
		for (Fact f : facts) {
			res &= g.contains(f.getEdge());
			if(!res)
				return false;
		}
		return res;
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

	public ArrayList<Edge> compute(Graph g) {
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
		
		ArrayList<Edge> intentionnal = new ArrayList<Edge>();
		
		ArrayList<String> listN1 = homomorphisme.get(this.result.getN1());
		ArrayList<String> listN2 = homomorphisme.get(this.result.getN2());
		
		if (listN1 == null || listN2 == null)
			return null;
		
		for (int i = 0 ; i < listN1.size() ; i++) {
			Edge newEdge = new Edge (g.getNode(listN1.get(i)), this.result.getEdge(), g.getNode(listN2.get(i)));
			if (!g.contains(newEdge))
				intentionnal.add(newEdge);
		}

		return intentionnal;
	}

	
}
