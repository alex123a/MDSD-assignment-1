package main;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class StateMachine {
	
	private Machine machine = new Machine();
	private Transition transition = new Transition();

	public Machine build() {
		Machine returnMachine = this.machine;
		this.machine = new Machine();
		return returnMachine;
	}

	public StateMachine state(String string) {
		State state = new State(string);
		this.machine.addState(state);
		this.machine.setCurrentState(state);
		return this;
	}

	public StateMachine initial() {
		this.machine.setInitialState(machine.getCurrentState());
		return this;
	}

	public StateMachine when(String string) {
		this.transition = new Transition();
		this.transition.setEvent(string);
		// Adding object reference to current state.
		this.machine.getCurrentState().addTransition(transition);
		return this;
	}

	public StateMachine to(String string) {
		this.transition.setTarget(new State(string));
		return this;
	}

	public StateMachine integer(String string) {
		this.machine.addInteger(string, 0);
		return this;
	}

	public StateMachine set(String string, int i) {
		this.transition.setOperation("set");
		this.transition.setOperationVariable(string);
		this.transition.setOperationValue(i);
		return this;
	}

	public StateMachine increment(String string) {
		this.transition.setOperation("increment");
		this.transition.setOperationVariable(string);
		return this;
	}

	public StateMachine decrement(String string) {
		this.transition.setOperation("decrement");
		this.transition.setOperationVariable(string);
		return this;
	}

	public StateMachine ifEquals(String string, int i) {
		this.transition.setConditional("equal");
		this.transition.setConditionalVariable(string);
		this.transition.setConditionalValue(i);
		return this;
	}

	public StateMachine ifGreaterThan(String string, int i) {
		this.transition.setConditional("greaterThan");
		this.transition.setConditionalVariable(string);
		this.transition.setConditionalValue(i);
		return this;
	}

	public StateMachine ifLessThan(String string, int i) {
		this.transition.setConditional("lessThan");
		this.transition.setConditionalVariable(string);
		this.transition.setConditionalValue(i);
		return this;
	}
}
