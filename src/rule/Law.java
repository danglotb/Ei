package rule;

import java.util.ArrayList;
import java.util.List;

import core.Graph;

public class Law {

	private static boolean checkAllRules(List<Rule> rules) {
		boolean check = false;
		for (Rule r : rules) {
			check |= r.wasApplied();
		}
		return check;
	}
	
	private static Graph merge(ArrayList<Graph> graphBuild) {
		if (graphBuild.isEmpty())
			return null;
		else 
			return graphBuild.get(0);
	}

	public static Graph apply(List<Rule> rules, Graph g) {
		Graph current = g.copy();
		Graph save = current;
		do {
			ArrayList<Graph> graphBuild = new ArrayList<Graph>();
			for (Rule r : rules) {
				Graph applied = r.applyTo(current);
				if (r.wasApplied())
					graphBuild.add(applied);
			}
			current = merge(graphBuild);
			if (current != null)
				save = current;
		} while (checkAllRules(rules) && current != null);
		return save;
	}

}
