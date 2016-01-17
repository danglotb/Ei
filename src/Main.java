import java.util.ArrayList;

import core.Graph;
import core.Node;
import rule.Law;
import rule.Rule;

public class Main {

	public static void main(String[] args) {
		
		Graph g = io.GraphReader.read("graph");
		
		System.out.println(g);
		
		Rule r1 = new Rule("x", "p1" , "y");
		r1.addFact("x", "E", "z");
		r1.addFact("y", "E", "z");
		
		Rule r2 = new Rule("x", "p2" , "y");
		r2.addFact("x", "p1", "z");
		r2.addFact("y", "p1", "z");
		
		Rule r3 = new Rule("x", "p3" , "y");
		r3.addFact("x", "p2", "z");
		r3.addFact("y", "p2", "z");
		
		ArrayList<Rule> prog = new ArrayList<Rule>();
		prog.add(r1);
		prog.add(r2);
		prog.add(r3);
		
		Graph g2 = Law.apply(prog, g);
		
		System.out.println(g2);
		
	}

}
