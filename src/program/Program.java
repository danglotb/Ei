package program;

import java.util.ArrayList;

import core.Edge;
import core.Graph;

public class Program {

	private ArrayList<Rule> rules;
	private Fact goal;

	public Program(Fact goal) {
		this.goal = goal;
		this.rules = new ArrayList<Rule>();
	}

	public Program(Fact goal, ArrayList<Rule> rules) {
		this.goal = goal;
		this.rules = rules;
	}

	public void addRule(Rule rule) {
		this.rules.add(rule);
	}

	public void run(Graph g) {
		
		//split the List of Rules into 2 sublist : initial and others
		ArrayList<Rule> initial = new ArrayList<Rule>();
		ArrayList<Rule> rules = new ArrayList<Rule>();
		
		for (Rule r : this.rules) {
			if (r.isInitial(g))
				initial.add(r);
			else
				rules.add(r);
		}
	

		Graph intentionnal = g.copy();

		ArrayList<Edge> initialEdge = new ArrayList<Edge>();

		for (Rule r : initial)
			initialEdge.addAll(r.compute(g));

		if (initialEdge.isEmpty()) {
			System.err.println("Could not apply any initial rule to the instance");
			System.exit(-1);
		} else
			intentionnal.getEdges().addAll(initialEdge);

		while (true) {
			
			ArrayList<ArrayList<Edge>> edges = new ArrayList<ArrayList<Edge>>();
			
			for (Rule r : rules) {
				ArrayList<Edge> tmp = r.compute(g);
				if (tmp != null)
					edges.add(tmp);
			}
			
			//We could not apply any rule
			if (edges.isEmpty())
				break;
			else {
				for (ArrayList<Edge> listEdge : edges) {
					for (Edge e : listEdge) {
						if (!intentionnal.getEdges().contains(e)) {
							intentionnal.getEdges().add(e);
						}
					}
				}
			}
		}
		
		if (intentionnal.contains(this.goal.getEdge())) {
			System.out.println("Goal found on :");
		} else
			System.out.println("Goal not found");

	}

}
