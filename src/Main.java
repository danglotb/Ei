import java.util.ArrayList;
import java.util.HashMap;

import core.Graph;
import program.Fact;
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
		
		System.out.println(g);
		
		Rule r = new Rule(new Fact("x", "p1", "y"));
		r.addFact(new Fact("x", "E", "z"));
		r.addFact(new Fact("z", "E", "y"));
		Rule r2 = new Rule(new Fact("x", "p2", "y"));
		r2.addFact("x", "p1", "z");
		r2.addFact("z", "p1", "x");
		HashMap<String, ArrayList<String>> h = r.compute(g);
		
		for (String key : h.keySet()) {
			System.out.println(key+":"+h.get(key));
		}
		
	}

}
