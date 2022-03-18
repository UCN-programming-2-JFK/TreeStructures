package runner;

import binarytree.BinaryStringNode;
import binarytree.BinaryStringTree;
import binarytree.BinaryStringTreeIteratorImplementation;
import binarytree.BinaryTreePrinter;
import compositepattern.Department;
import compositepattern.Organization;

public class Program {

	public static void main(String[] args) {

		testBinaryTree();

		//testCompositePattern();
	}

	private static void testBinaryTree()
	{
		BinaryStringTree tree = new BinaryStringTree();

		// a+b*(c-d)

		// create all nodes first
		BinaryStringNode aNode = new BinaryStringNode("a");
		BinaryStringNode plusNode = new BinaryStringNode("+");
		
		BinaryStringNode bNode = new BinaryStringNode("b");
		BinaryStringNode multiplyNode = new BinaryStringNode("*");
		BinaryStringNode minusNode = new BinaryStringNode("-");
		BinaryStringNode cNode = new BinaryStringNode("c");
		BinaryStringNode dNode = new BinaryStringNode("d");

		// add the nodes so they can be navigated InOrder to solve the equation
		tree.setRoot(plusNode);

		plusNode.setLeft(aNode);
		plusNode.setRight(multiplyNode);

		multiplyNode.setLeft(bNode);
		multiplyNode.setRight(minusNode);

		minusNode.setLeft(cNode);
		minusNode.setRight(dNode);

		//display contents using different methods
		System.out.println("BinaryStringTree.toString(): ");
		System.out.println(tree);
		System.out.println();
		
		System.out.println("BinaryTreePrinter.printTreeInOrder(tree): ");
		BinaryTreePrinter.printTreeInOrder(tree);
		System.out.println();
		
		BinaryStringTreeIteratorImplementation bsti = new BinaryStringTreeIteratorImplementation();
		bsti.setRoot(plusNode);

		System.out.println("BinaryStringTreeIteratorImplementation iterator implementation: ");
		for (BinaryStringNode node : bsti) {
			System.out.println(node);
		}
		System.out.println();
	}

	private static void testCompositePattern() {

//		Organization {name=”Incorporated Funny Business”} 
//			Organization { name=” Novelty items”}
//				Department { name=”research and development”, noOfEmployees: 4 }
//			Organization { name=”Party Tricks” }
//				Department { name=”research and development”, noOfEmployees: 12 }
//				Department { name=”research and development”, noOfEmployees: 2 }
//			Department { name=”Human resources”, noOfEmployees: 4 }
//			Department { name=”Administration”, noOfEmployees: 20 }

		Organization funnyBusinessInc = new Organization("Funny Business inc.");
		funnyBusinessInc.getSubUnits().add(new Department("Human resources", 4));
		funnyBusinessInc.getSubUnits().add(new Department("Administration", 20));

		Organization noveltyItems = new Organization("Novelty Items");
		noveltyItems.getSubUnits().add(new Department("Research & development", 4));

		funnyBusinessInc.getSubUnits().add(noveltyItems);

		Organization partyTricksOrganizationalUnit = new Organization("Party tricks");
		partyTricksOrganizationalUnit.getSubUnits().add(new Department("Research & development", 12));
		partyTricksOrganizationalUnit.getSubUnits().add(new Department("Sales", 2));

		funnyBusinessInc.getSubUnits().add(partyTricksOrganizationalUnit);
		
		System.out.println(funnyBusinessInc);
	}
}