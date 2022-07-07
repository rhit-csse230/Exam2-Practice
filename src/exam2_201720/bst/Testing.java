package exam2_201720.bst;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Test;


public class Testing {

	private static int countOneChildParentsPoints = 0;
	private static int pruneLeavesPoints = 0;
	private static int branchPointPoints = 0;
	
	
	@Test
	public void testCountOneChildParents() {
		BinarySearchTree b = new BinarySearchTree();
		assertEquals(0, b.countOneChildParents());
		countOneChildParentsPoints += 2;
		b.insert(50);
		assertEquals(0, b.countOneChildParents());
		countOneChildParentsPoints += 2;
		b.insert(70);
		assertEquals(1, b.countOneChildParents());
		countOneChildParentsPoints += 3;
		b.insert(30);
		assertEquals(0, b.countOneChildParents());
		countOneChildParentsPoints += 2;
		b.insert(40);
		b.insert(60);
		assertEquals(2, b.countOneChildParents());
		countOneChildParentsPoints += 2;
		b.insert(42);
		b.insert(44);
		b.insert(46);
		b.insert(48);
		assertEquals(6, b.countOneChildParents());
		countOneChildParentsPoints += 2;
		b.insert(43);
		b.insert(45);
		assertEquals(4, b.countOneChildParents());
		countOneChildParentsPoints += 2;
		b.insert(72);
		b.insert(74);
		assertEquals(4, b.countOneChildParents());
		countOneChildParentsPoints += 2;
	}


	private BinarySearchTree buildTree1() {
		BinarySearchTree t = new BinarySearchTree();
		t.insert(10);
		t.insert(5);
		t.insert(50);
		t.insert(30);
		t.insert(20);
		t.insert(40);
		t.insert(90);
		t.insert(80);
		t.insert(70);
		t.insert(60);
		t.insert(95);
		t.insert(97);
		return t;
	}
	
	private BinarySearchTree buildTree2() {
		BinarySearchTree t = new BinarySearchTree();
		t.insert(100);
		t.insert(50);
		t.insert(25);
		t.insert(75);
		t.insert(150);
		t.insert(175);
		t.insert(160);
		t.insert(155);
		t.insert(162);
		t.insert(90);
		t.insert(12);
		t.insert(37);
		t.insert(6);
		t.insert(8);
		t.insert(7);
		t.insert(10);
		t.insert(11);
		return t;
	}
	
	@Test
	public void testPruneLeavesSimple() {
		BinarySearchTree b = new BinarySearchTree();
		assertEquals("[]", b.toListString());
		b.insert(10);
		assertEquals("[10]", b.toListString());
		b.pruneLeaves();
		assertEquals("[]", b.toListString());
		pruneLeavesPoints += 2;
		b.insert(10);
		b.insert(15);
		b.pruneLeaves();
		assertEquals("[10]", b.toListString());
		pruneLeavesPoints += 2;
		b.insert(10);
		b.insert(15);
		b.insert(12);
		b.insert(17);
		b.insert(5);
		assertEquals("[5, 10, 12, 15, 17]", b.toListString());
		b.pruneLeaves();
		assertEquals("[10, 15]", b.toListString());
		pruneLeavesPoints += 2;
		b = new BinarySearchTree(); // Empty tree
		b.pruneLeaves();
		assertEquals("[]", b.toListString());
		pruneLeavesPoints += 2;
	}

	
	@Test
	public void testPruneLeaves() {
		BinarySearchTree b = buildTree1();
		b.pruneLeaves();
		assertEquals("[10, 30, 50, 70, 80, 90, 95]", b.toListString());
		pruneLeavesPoints += 3;
		b.pruneLeaves();
		assertEquals("[10, 50, 80, 90]", b.toListString());
		pruneLeavesPoints += 3;
		b = buildTree2();
		b.pruneLeaves();
		assertEquals("[6, 8, 10, 12, 25, 50, 75, 100, 150, 160, 175]", b.toListString());	
		pruneLeavesPoints += 3;	
	}
	

	
	@Test
	public void testBranchPointSuccessfulSearch() {
		BinarySearchTree b = buildTree2();
		assertEquals(new Integer(100), b.branchPoint(50,150));
		assertEquals(new Integer(25), b.branchPoint(6,37));
		assertEquals(new Integer(8), b.branchPoint(7,10));
		assertEquals(new Integer(50), b.branchPoint(17,75));
		assertEquals(new Integer(160), b.branchPoint(155,162));
		branchPointPoints += 4;
	}
	
	@Test
	public void testBranchPointSuccessfulSearchSameBranch() {
		BinarySearchTree b = buildTree2();
		assertEquals(new Integer(100), b.branchPoint(50,100));
		assertEquals(new Integer(25), b.branchPoint(25,37));
		assertEquals(new Integer(12), b.branchPoint(11,12));
		branchPointPoints += 2;
	}

	
	@Test
	public void testBranchPointSameValue() {
		BinarySearchTree b = buildTree2();
		assertEquals(new Integer(75), b.branchPoint(75,75));
		assertEquals(new Integer(10), b.branchPoint(10,10));
		assertEquals(new Integer(100), b.branchPoint(100,100));
		branchPointPoints += 2;
	}
	
	@Test
	public void testBranchPointOutOfOrder() {
		BinarySearchTree b = buildTree2();
		assertEquals(new Integer(100), b.branchPoint(150,50));
		assertEquals(new Integer(25), b.branchPoint(37,6));
		assertEquals(new Integer(8), b.branchPoint(10,7));
		branchPointPoints += 3;
	}

	
	@Test
	public void testBranchPointOneNotInTree() {
		BinarySearchTree b = buildTree2();
		assertEquals(new Integer(25), b.branchPoint(1,37));
		assertEquals(new Integer(8), b.branchPoint(7,9));
		assertEquals(new Integer(100), b.branchPoint(95,155));
		branchPointPoints += 2;
	}


	@Test
	public void testBranchPointBothNotInTree() {
		BinarySearchTree b = buildTree2();
		assertEquals(new Integer(6), b.branchPoint(1,9));
		assertEquals(new Integer(50), b.branchPoint(24,76));
		assertEquals(new Integer(150), b.branchPoint(149,151));
		branchPointPoints += 1;
	}


	@Test
	public void testBranchPointNull() {
		BinarySearchTree b = buildTree2();
		assertEquals(null, b.branchPoint(40,45));
		assertEquals(null, b.branchPoint(13,24));
		assertEquals(null, b.branchPoint(1,1));
		assertEquals(null, b.branchPoint(200,300));
		branchPointPoints += 3;
	}


	
	
	@AfterClass
	public static void displayPoints() {
		System.out.printf("%2d/17 countOneChildParents correctness points\n", countOneChildParentsPoints);
		System.out.printf("%2d/17 pruneLeaves correctness points\n", pruneLeavesPoints);
		System.out.printf("%2d/17 branchPoint correctness points\n", branchPointPoints);
		System.out.printf(" _/5  branchPoint efficiency will be checked by the instructor\n");
		System.out.printf(" _/4  elegance will be checked by the instructor\n");

	}
}
