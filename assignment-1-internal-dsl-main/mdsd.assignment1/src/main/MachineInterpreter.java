package main;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class MachineInterpreter {
	Machine machine;
	int test = 1;
	
    public void run(Machine m) {
    	this.machine = m;
    	this.machine.setCurrentState(this.machine.getInitialState());
    }

    public State getCurrentState() {
        return this.machine.getCurrentState();
    }

    public void processEvent(String string) {
    	boolean firstTime = true;
    	
    	
		List<Transition> transitions = this.machine.getCurrentState().getTransitions();
	    State starterState = this.machine.getCurrentState();
	    transitions = transitions.stream().filter(transition -> transition.getEvent().equals(string)).toList();
	    
	    
    	if (transitions.size() > 0) {
    		for (Transition transition: transitions) {
    			boolean process = true;
    			if (!firstTime && this.machine.getCurrentState().getName() != starterState.getName()) {
    				break;
    			}
    			firstTime = false;
		    	Integer value = this.machine.getInteger(transition.getOperationVariableName());
		    	Integer conditionValue = transition.getConditionComparedValue();
		    	
		    	if (transition.isConditional()) {
			    	if (transition.isConditionEqual()) {
			    		process = this.machine.getInteger(transition.getConditionVariableName()) == conditionValue;
			    	} else if (transition.isConditionGreaterThan()) {
			    		process = this.machine.getInteger(transition.getConditionVariableName()) > conditionValue;
			    	} else if (transition.isConditionLessThan()) {
			    		process = this.machine.getInteger(transition.getConditionVariableName()) < conditionValue;
			    	}
		    	}
		    	
		    	if (process) {
			    	if (transition.hasSetOperation()) {
			    		this.machine.addInteger(transition.getOperationVariableName(), transition.getOperationValue());
			    	} else if (transition.hasIncrementOperation()) {
			    		this.machine.addInteger(transition.getOperationVariableName(), value + 1);
			    	} else if (transition.hasDecrementOperation()) {
			    		this.machine.addInteger(transition.getOperationVariableName(), value - 1);
			    	} 
			    	
		    		this.machine.setCurrentState(this.machine.getState(transition.getTarget().getName()));

		    	}
    		}
    	}
    }

    public int getInteger(String string) {
        return this.machine.getInteger(string);
    }
}
