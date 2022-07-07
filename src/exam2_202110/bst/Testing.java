package exam2_202110.bst;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

public class Testing {

	private static int countSiblingDiffGreaterThanPoints = 0;
	private static int buildSearchPathListPoints = 0;
	private static int sproutToDepthPoints = 0;

	private BinarySearchTree exampleT1() {
		BinarySearchTree bst = new BinarySearchTree();
		final Integer array[] = { 77, 37, 93, 35, 52, 90, 94, 36 };
		for (int k = 0; k < array.length; k++) {
			bst.insert(array[k]);
		}
		return bst;
	}

	private BinarySearchTree exampleT2() {
		BinarySearchTree bst = new BinarySearchTree();
		final Integer array[] = { 11, 37, 35, 77, 20, 52, 93, 29, 90, 94 };
		for (int k = 0; k < array.length; k++) {
			bst.insert(array[k]);
		}
		return bst;
	}


	@Test
	public void countSiblingDiffGreaterThanOnSmallTrees() {
		BinarySearchTree bst = new BinarySearchTree();
		
		assertEquals(0, bst.countSiblingDiffGreaterThan(8));
		countSiblingDiffGreaterThanPoints += 2;
		
		bst.insert(20);
		assertEquals(0, bst.countSiblingDiffGreaterThan(8));

		bst.insert(15);
		assertEquals(0, bst.countSiblingDiffGreaterThan(8));

		bst.insert(25); // Now has a single sibling difference of 10
		assertEquals(1, bst.countSiblingDiffGreaterThan(8));
		assertEquals(0, bst.countSiblingDiffGreaterThan(12));
		countSiblingDiffGreaterThanPoints += 2;
	}

	
	@Test
	public void countSiblingDiffGreaterThanOnT1() {
		BinarySearchTree bst = exampleT1();
		assertEquals(1, bst.countSiblingDiffGreaterThan(50));
		countSiblingDiffGreaterThanPoints += 1;
		
		assertEquals(0, bst.countSiblingDiffGreaterThan(60));
		countSiblingDiffGreaterThanPoints += 1;

		assertEquals(2, bst.countSiblingDiffGreaterThan(15));
		countSiblingDiffGreaterThanPoints += 2;

		assertEquals(3, bst.countSiblingDiffGreaterThan(3));
		countSiblingDiffGreaterThanPoints += 2;
	}
	
	@Test
	public void countSiblingDiffGreaterThanOnT2() {
		BinarySearchTree bst = exampleT2();
		// Ensuring the sibling difference is strictly greater.
		assertEquals(1, bst.countSiblingDiffGreaterThan(41));
		countSiblingDiffGreaterThanPoints += 1;
		
		assertEquals(0, bst.countSiblingDiffGreaterThan(42));
		countSiblingDiffGreaterThanPoints += 1;

		assertEquals(2, bst.countSiblingDiffGreaterThan(40));
		assertEquals(2, bst.countSiblingDiffGreaterThan(4));
		countSiblingDiffGreaterThanPoints += 2;

		assertEquals(3, bst.countSiblingDiffGreaterThan(3));
		countSiblingDiffGreaterThanPoints += 2;
	}
	
	@Test
	public void buildSearchPathListOnSmallTrees() {
		BinarySearchTree bst = new BinarySearchTree();		
		bst.insert(10);
		assertEquals("[10]", bst.buildSearchPathList(10).toString());		
		buildSearchPathListPoints += 1;
		
		bst.insert(5);
		bst.insert(15);	
		assertEquals("[10, 5]", bst.buildSearchPathList(5).toString());		
		assertEquals("[10, 15]", bst.buildSearchPathList(15).toString());		
		assertEquals("[10]", bst.buildSearchPathList(10).toString());		
		buildSearchPathListPoints += 1;
	}
	
	
	@Test
	public void buildSearchPathListOnT1() {
		BinarySearchTree bst = exampleT1();		

		assertEquals("[77, 37, 35]", bst.buildSearchPathList(35).toString());		
		buildSearchPathListPoints += 1;

		assertEquals("[77, 37, 35, 36]", bst.buildSearchPathList(36).toString());		
		buildSearchPathListPoints += 1;

		assertEquals("[77, 37, 52]", bst.buildSearchPathList(52).toString());		
		buildSearchPathListPoints += 1;

		assertEquals("[77, 93, 90]", bst.buildSearchPathList(90).toString());		
		buildSearchPathListPoints += 1;

		assertEquals("[77, 93, 94]", bst.buildSearchPathList(94).toString());		
		buildSearchPathListPoints += 1;

		assertEquals("[77, 93]", bst.buildSearchPathList(93).toString());		
		buildSearchPathListPoints += 1;
	}

	
	@Test
	public void buildSearchPathListOnT2() {
		BinarySearchTree bst = exampleT2();		

		assertEquals("[11]", bst.buildSearchPathList(11).toString());		
		assertEquals("[11, 37]", bst.buildSearchPathList(37).toString());		
		assertEquals("[11, 37, 35, 20]", bst.buildSearchPathList(20).toString());		
		assertEquals("[11, 37, 77, 93, 90]", bst.buildSearchPathList(90).toString());		
		assertEquals("[11, 37, 77, 93, 94]", bst.buildSearchPathList(94).toString());		
		assertEquals("[11, 37, 77, 93]", bst.buildSearchPathList(93).toString());		
		buildSearchPathListPoints += 5;
	}

	@Test
	public void buildSearchPathListNotFound() {
		BinarySearchTree bst = exampleT1();		
		assertEquals("[]", bst.buildSearchPathList(100).toString());		
		assertEquals("[]", bst.buildSearchPathList(55).toString());		

		
		bst = exampleT2();		
		assertEquals("[]", bst.buildSearchPathList(10).toString());		
		assertEquals("[]", bst.buildSearchPathList(19).toString());		
		
		// Make sure that regular search still works before awarding points. :)
		assertEquals("[11, 37, 77, 52]", bst.buildSearchPathList(52).toString());		
		
		buildSearchPathListPoints += 2;
	}
	
	@Test
	public void sproutToDepthStartingFull() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(3);
		bst.sproutToDepth(1);
		assertEquals("[3, 3, 3]",bst.toString());
		assertEquals(1,bst.height());
		bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(2);
		bst.insert(6);
		bst.sproutToDepth(2);
		assertEquals("[2, 2, 2, 5, 6, 6, 6]",bst.toString());
		assertEquals(2,bst.height());
		bst = new BinarySearchTree();
		bst.insert(20);
		bst.insert(10);
		bst.insert(30);
		bst.insert(5);
		bst.insert(15);
		bst.insert(25);
		bst.insert(35);
		bst.sproutToDepth(3); // Since all NULL_NODEs are at depth 3, all sprout
		assertEquals("[5, 5, 5, 10, 15, 15, 15, 20, 25, 25, 25, 30, 35, 35, 35]",bst.toString());
		assertEquals(3,bst.height()); 
		sproutToDepthPoints += 8;
		bst = new BinarySearchTree();
		bst.insert(20);
		bst.insert(10);
		bst.insert(30);
		bst.insert(5);
		bst.insert(15);
		bst.insert(25);
		bst.insert(35);
		bst.sproutToDepth(2); // Since all NULL_NODEs are at depth 3, none sprout
		assertEquals("[5, 10, 15, 20, 25, 30, 35]",bst.toString());
		assertEquals(2,bst.height()); 
		sproutToDepthPoints += 2;
	}

	private BinarySearchTree simpleTree() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);   //       5
		bst.insert(2);   //  2         6
		bst.insert(6);   //     4
		bst.insert(4);   //    3
		bst.insert(3);
		return bst;
	}
	
	
	@Test
	public void sproutToDepthStartingNotFull() {
		BinarySearchTree bst;
		bst = simpleTree();
		bst.sproutToDepth(1);
		assertEquals("[2, 3, 4, 5, 6]",bst.toString());
		bst = simpleTree();
		bst.sproutToDepth(2);
		assertEquals("[2, 2, 3, 4, 5, 6, 6, 6]",bst.toString());
		bst = simpleTree();
		bst.sproutToDepth(3);
		assertEquals("[2, 2, 3, 4, 4, 5, 6, 6, 6]",bst.toString());
		bst = simpleTree();
		bst.sproutToDepth(4);
		assertEquals("[2, 2, 3, 3, 3, 4, 4, 5, 6, 6, 6]",bst.toString());
		sproutToDepthPoints += 4;
	}

	@Test
	public void sproutToDepthStartingEmpty() {
		BinarySearchTree bst;
		bst = new BinarySearchTree();
		bst.sproutToDepth(-1); // should not sprout
		assertEquals("[]",bst.toString());
		assertEquals(-1,bst.height());
		bst.sproutToDepth(0); // sprouts the empty tree
		assertEquals("[0]",bst.toString());
		assertEquals(0,bst.height());
		sproutToDepthPoints += 1;
	}

	@Test
	public void sproutToDepthExamples() {
		BinarySearchTree bst;
		bst = exampleT2();
		bst.sproutToDepth(3);
		assertEquals("[11, 11, 20, 29, 35, 35, 37, 52, 77, 90, 93, 94]",bst.toString());
		bst = exampleT2();
		bst.sproutToDepth(4);
		assertEquals("[11, 11, 20, 20, 29, 35, 35, 37, 52, 52, 52, 77, 90, 93, 94]",bst.toString());
		sproutToDepthPoints += 5;
	}


	@AfterClass
	public static void displayPoints() {
		System.out.printf("%2d/16 countSiblingDiffGreaterThan points\n", countSiblingDiffGreaterThanPoints);

		System.out.printf("%2d/15 buildSearchPath points\n", buildSearchPathListPoints);
		System.out.printf(" ?/ 5 efficiency points will be checked by the instructor\n", buildSearchPathListPoints);

		System.out.printf("%2d/20 sproutToDepth points\n", sproutToDepthPoints);
		System.out.printf(" ?/ 4 overall for elegance will be checked by the instructor\n");

	}
}
