package main.metamodel;

import java.util.HashMap;
import java.util.Map;

public class Transition{
	private String event;
	private State target;
	private String operation;
	private String operationVariable;
	private String conditional;
	private String conditionalVariable;
	private Integer conditionalValue;
	
	public Transition(String event, State target) {
		this.event = event;
		this.target = target;
	}
	
	public Transition(String event, State target, String operation, String operationVariable) {
		this(event, target);
		this.operation = operation;
		this.operationVariable = operationVariable;
	}
	
	public Transition(String event, State target, String conditional, String conditionalVariable, Integer conditionalValue) {
		this(event, target);
		this.conditional = conditional;
		this.conditionalVariable = conditionalVariable;
		this.conditionalValue = conditionalValue;
	}
	
	
	public Transition(String event, State target, String operation, String operationVariable, String conditional, String conditionalVariable, Integer conditionalValue) {
		this(event, target, operation, operationVariable);
		this.conditional = conditional;
		this.conditionalVariable = conditionalVariable;
		this.conditionalValue = conditionalValue;
	}
	
	public String getEvent() {
		return this.event;
	}

	public State getTarget() {
		return this.target;
	}
	
	public boolean hasOperation() {
		return this.operation != "";
	}

	public boolean hasSetOperation() {
		return this.operation == "set";
	}

	public boolean hasIncrementOperation() {
		return this.operation == "increment";
	}

	public boolean hasDecrementOperation() {
		return this.operation == "decrement";
	}

	public Object getOperationVariableName() {
		return this.operationVariable;
	}

	public boolean isConditional() {
		return this.conditional != "";
	}

	public Object getConditionVariableName() {
		return this.conditionalVariable;
	}

	public Integer getConditionComparedValue() {
		return this.conditionalValue;
	}

	public boolean isConditionEqual() {
		return this.conditional == "equal";
	}

	public boolean isConditionGreaterThan() {
		return this.conditional == "greaterThan";
	}

	public boolean isConditionLessThan() {
		return this.conditional == "lessThan";
	}
}
