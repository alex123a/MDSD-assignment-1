package main.metamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Machine {
	private List<State> states = new ArrayList<State>();
	private Integer initialState;
	private Integer currentState;
	private Map<String, Integer> integers = new HashMap<>();
	
	public Machine() {
		
	}

	public List<State> getStates() {
		return states;
	}

	public State getInitialState() {
		return states.get(this.initialState);
	}
	
	public State getCurrentState() {
		return states.get(this.currentState);
	}

	public State getState(String string) {
		State state = this.states.stream().filter(theState -> string.equals(theState.getName())).findFirst().get();
		return state;
	}
	
	public Integer getInteger(String string) {
		return this.integers.get(string);
	}

	public int numberOfIntegers() {
		return this.integers.size();
	}

	public boolean hasInteger(String string) {
		return this.integers.containsKey(string);
	}
	
	public void addInteger(String key, Integer value) {
		this.integers.put(key, value);
	}
	
	public void addState(State state) {
		states.add(state);
	}
	
	public void setInitialState(State state) {
		this.initialState = states.indexOf(state);
	}
	
	public void setCurrentState(State state) {
		this.currentState = states.indexOf(state);
	} 
}

