package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import equationcalculator.EquationNode;
import equationcalculator.EquationParserTool;

class EquationParserToolTests {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testEquationSimpleSplit() {
		String equation = "A+B";
		String[] result = EquationParserTool.splitEquationIfOperatorPresent(equation);
		assertEquals(3, result.length);
	}
	
	@Test
	void testEquationSimpleSplitCalculation() {
		String equation = "3+5*2";
		EquationNode node = new EquationNode(equation);
		assertEquals(13,node.getValue());
	}
	
	
	@Test
	void testEquationComplexSplitCalculation() {
		String equation = "38-2*3+5*2";
		EquationNode node = new EquationNode(equation);
		assertEquals(42, node.getValue());
	}

}
