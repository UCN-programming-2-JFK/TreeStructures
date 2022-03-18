package equationcalculator;;

public class EquationParserTool {

	public class Operators {
		public static final String Plus = "+";
		public static final String Minus = "-";
		public static final String Multiply = "*";
		public static final String Divide = "/";
		public static final String[] PlusAndMinus = new String[] {Operators.Plus, Operators.Minus};
		public static final String[] MultiplyAndDivide = new String[] {Operators.Multiply, Operators.Divide};
		}
	
	private EquationParserTool() {}
	
	public static boolean hasPlusOrMinus(String stringToCheck) {
		return stringToCheck.contains("+") || stringToCheck.contains("-");
	}
	
	public static boolean hasMultiplyOrDivide(String stringToCheck) {
		return stringToCheck.contains("*") || stringToCheck.contains("/");
	}
	
	public static String[] splitEquationIfOperatorPresent(String equationToProcess) {
		
		for (int characterIndex = equationToProcess.length()-1; characterIndex >=0 ; characterIndex--) {
			char character = equationToProcess.charAt(characterIndex);
			String characterAsString = Character.toString(character);
			String operatorFound = null;
			if(characterAsString.equals(Operators.Plus)) {operatorFound = Operators.Plus;}
			if(characterAsString.equals(Operators.Minus)) {operatorFound = Operators.Minus;}
			
			if(operatorFound != null) {
				return splitAtOperator(equationToProcess, characterAsString);
			}
		}
		
		for (int characterIndex = equationToProcess.length()-1; characterIndex >=0 ; characterIndex--) {
			char character = equationToProcess.charAt(characterIndex);
			String characterAsString = Character.toString(character);
			String operatorFound = null;
			if(characterAsString.equals(Operators.Multiply)) {operatorFound = Operators.Multiply;}
			if(characterAsString.equals(Operators.Divide)) {operatorFound = Operators.Divide;}
			
			if(operatorFound != null) {
				return splitAtOperator(equationToProcess, characterAsString);
			}
		}
		
		return new String[] { equationToProcess};
	}
	
	public static String[] splitAtOperator(String stringToSplit, String operatorToSplitAt) {
		if(!stringToSplit.contains(operatorToSplitAt)) {throw new IllegalArgumentException("Operator '" + operatorToSplitAt + "' unknown!");}
		
		int position = stringToSplit.indexOf(operatorToSplitAt);
		String[] returnValues = new String[] {stringToSplit.substring(0, position), stringToSplit.substring(position, position+1), stringToSplit.substring(position+1)};
		return returnValues;
	}
}
