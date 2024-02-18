package main.metamodel;

import java.util.List;

public class State {
	private String name;
	private List<Transition> transitions;
	
	public State(String name, List<Transition> transitions) {
		this.name = name;
		this.transitions = transitions;
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
}
