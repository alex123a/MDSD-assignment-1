package main.metamodel;

public class Transition{
	private String event;
	private State target;
	private String operation = "";
	private String operationVariable = "";
	private Integer operationValue = 0;
	private String conditional = "";
	private String conditionalVariable = "";
	private Integer conditionalValue = 0;
	
	public Transition() {
		
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

	public String getOperationVariableName() {
		return this.operationVariable;
	}
	
	public Integer getOperationValue() {
		return this.operationValue;
	}

	public boolean isConditional() {
		return this.conditional != "";
	}

	public String getConditionVariableName() {
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
	
	public Transition setEvent(String string) {
		this.event = string;
		return this;
	}
	
	public Transition setTarget(State state) {
		this.target = state;
		return this;
	}
	
	public Transition setOperation(String string) {
		this.operation = string;
		return this;
	}
	
	public Transition setOperationVariable(String string) {
		this.operationVariable = string;
		return this;
	}
	
	public Transition setOperationValue(Integer value) {
		this.operationValue = value;
		return this;
	}
	
	public Transition setConditional(String string) {
		this.conditional = string;
		return this;
	}
	
	public Transition setConditionalVariable(String string) {
		this.conditionalVariable = string;
		return this;
	}
	
	public Transition setConditionalValue(Integer value) {
		this.conditionalValue = value;
		return this;
	}
}
