import java.util.ArrayList;

import core.Graph;
import program.Fact;
import program.Program;
import program.Rule;

public class Main {
	
	public static void main(String[] args) {
		
		Graph g = new Graph();
		for (int i = 0 ; i < 8 ; i++) {
			g.addNode(i+"");
		}
		
		for (int i = 0 ; i < 7 ; i++) {
			g.addEdge(g.getNode(i+""), "E", g.getNode((i+1)+""));
		}
		
		Rule r = new Rule(new Fact("x", "p1", "y"));
		r.addFact(new Fact("x", "E", "z"));
		r.addFact(new Fact("z", "E", "y"));
		Rule r2 = new Rule(new Fact("x", "p2", "y"));
		r2.addFact(new Fact("x", "p1", "z"));
		r2.addFact(new Fact("z", "p1", "y"));
		
		ArrayList<Rule> rules = new ArrayList<Rule>();
		rules.add(r); rules.add(r2);
		
		g.getEdges().addAll(r.compute(g));
		
		Program p = new Program(new Fact("x", "p2", "y"), rules);
		
		p.run(g);
		
		
	}

}
