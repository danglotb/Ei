package program;

import java.util.ArrayList;

import core.Edge;

public class Program {
	
	private ArrayList<Edge> schemeInt;
	private ArrayList<Rule> rules;
	private Fact goal;
	
	public Program(Fact goal) {
		this.goal = goal;
		this.schemeInt = new ArrayList<Edge>();
		this.rules = new ArrayList<Rule>();
	}
	
	public Program(Fact goal, ArrayList<Rule> rules) {
		this.goal = goal;
		this.rules = rules;
		this.schemeInt = new ArrayList<Edge>();
	}
	
	public void addRule(Rule rule) {
		this.rules.add(rule);
	}
	
	public void run() {
		
	}

}
