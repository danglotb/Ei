package program;

import java.util.ArrayList;

import core.Edge;
import core.Graph;

public class Program {
	
	private ArrayList<Edge> schemeInt;
	private ArrayList<Rule> rules;
	private ArrayList<Rule> initial;
	private Fact goal;
	
	public Program(Fact goal) {
		this.goal = goal;
		this.schemeInt = new ArrayList<Edge>();
		this.rules = new ArrayList<Rule>();
		this.initial = new ArrayList<Rule>();
	}
	
	public Program(Fact goal, ArrayList<Rule> rules) {
		this.goal = goal;
		this.rules = rules;
		this.schemeInt = new ArrayList<Edge>();
		this.initial = new ArrayList<Rule>();
	}
	
	public void addRule(Rule rule, Graph g) {
		if (rule.isInitial(g))
			this.initial.add(rule);
		else 
			this.rules.add(rule);
	}
	
	public void run() {
		
	}

}
