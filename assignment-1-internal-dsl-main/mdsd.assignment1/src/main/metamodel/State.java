package main.metamodel;

import java.util.ArrayList;
import java.util.List;

public class State {
	private String name;
	private List<Transition> transitions = new ArrayList<Transition>();
	
	public State(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public List<Transition> getTransitions() {
		return this.transitions;
	}

	public Transition getTransitionByEvent(String string) {
		return this.transitions.stream().filter(theTransition -> string.equals(theTransition.getEvent())).findFirst().get();
	}
	
	public void addTransition(Transition transition) {
		this.transitions.add(transition);
	}
	
	public void removeTransition(Transition transition) {
		this.transitions.remove(transition);
	}
}
