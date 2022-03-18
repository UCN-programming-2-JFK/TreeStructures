package equationcalculator;

public class EquationNode {
	private EquationNode left, right;
	private Float value;
	private String operator;

	public EquationNode getLeft() {
		return left;
	}

	public void setLeft(EquationNode left) {
		this.left = left;
	}

	public EquationNode getRight() {
		return right;
	}

	public void setRight(EquationNode right) {
		this.right = right;
	}
	
	public EquationNode(String equation) {
		setEquation(equation);
	}
	public void setValue(float value) {
		this.value = value;
	}
	public float getValue() {
		if(this.value != null) {return value;}
		else {
			float leftValue = getLeft().getValue();
			float rightValue = getRight().getValue();
			switch (getOperator()) {
			case EquationParserTool.Operators.Plus:
				return leftValue + rightValue;
			case EquationParserTool.Operators.Minus:
				return leftValue - rightValue;
			case EquationParserTool.Operators.Multiply:
				return leftValue * rightValue;
			case EquationParserTool.Operators.Divide:
				return leftValue / rightValue;
			default:
				throw new IllegalArgumentException("Unknown operator '" + getOperator() + "'");
			}
		}
	}
	
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public EquationNode() {}
	
	public void setEquation(String equation) {
		if(equation == null || equation.length()==0) {
			throw new IllegalArgumentException("Null or empty string sent to setEquation()!");
		}
		String[] equationParsed = EquationParserTool.splitEquationIfOperatorPresent(equation);
		if(equationParsed.length == 3) {
			EquationNode leftEquationNode = new EquationNode(equationParsed[0]);
			setLeft(leftEquationNode);
			
			setOperator(equationParsed[1]);
			EquationNode rightEquationNode = new EquationNode(equationParsed[2]);
			setRight(rightEquationNode);
		}
		else {
			if(equationParsed.length == 1) {
				setValue(Float.parseFloat(equationParsed[0]));
			}
		}
			
	}
	
	@Override
	public String toString() {
		if(this.value != null) {return this.value.toString().toString();}
		return this.getOperator().toString();
	}
}
