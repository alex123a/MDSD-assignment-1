package main.metamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Machine {
	private List<State> states = new ArrayList<State>();
	private State initialState;
	private Map<String, Integer> integers = new HashMap<>();
	
	public Machine(List<State> states, State initialState) {
		this.states = states;
		this.initialState = initialState;
	}

	public List<State> getStates() {
		return states;
	}

	public State getInitialState() {
		return initialState;
	}

	public State getState(String string) {
		State state = this.states.stream().filter(theState -> string.equals(theState.getName())).findFirst().get();
		
		return state;
	}

	public int numberOfIntegers() {
		return this.integers.size();
	}

	public boolean hasInteger(String string) {
		return this.integers.containsKey(string);
	}
	
	public void addInteger(String key, int value) {
		this.integers.put(key, value);
	}
}

