/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
	
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}


	/* Utility method for constructor checks.*/
	public static boolean checkconstructor(LinkedListDeque expected,LinkedListDeque actual){
		for(int i=0;i< expected.size();i++){
			if(expected.get(i)!=actual.get(i)){
				System.out.println("different index=:"+i);
				return false;
			}
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
		/* check isEmpty()*/
		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
		boolean passed = checkEmpty(true, lld1.isEmpty());

		/* check addFirst to an empty list */
		lld1.addFirst("addfirst1");
		passed = checkEmpty(false, lld1.isEmpty()) && passed;
		/* check addfirst to an not-empty list*/
		lld1.addFirst("addfirst2");
		passed = checkSize(2, lld1.size()) && passed;

		/* check addlast to an empty list*/
		LinkedListDeque<String> lld2 = new LinkedListDeque<String>();
		lld2.addLast("addlast1");
	    passed = checkEmpty(false, lld2.isEmpty());
	    /* check addlast to an none-empty list*/
		lld2.addLast("addlast2");
		passed = checkSize(2, lld2.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);

	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");

		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		boolean passed = checkEmpty(true, lld1.isEmpty());
		lld1.addFirst(10);
		passed = checkEmpty(false, lld1.isEmpty()) && passed;
		lld1.removeFirst();
		passed = checkEmpty(true, lld1.isEmpty()) && passed;
		printTestStatus(passed);

	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void constructorTest() {
		System.out.println("Running constructor test.");
		/* empty constructor*/
		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		boolean passed = checkEmpty(true,lld1.isEmpty());
		/* one size constructor*/
		LinkedListDeque<Integer> lld2 = new LinkedListDeque<Integer>(2);
		passed = checkSize(1,lld2.size()) && passed;
		lld2.addLast(3);
		lld2.addFirst(1);

		/* copy ocnstructor*/
		LinkedListDeque<Integer> lld3 = new LinkedListDeque<Integer>(lld2);
		passed = checkconstructor(lld2,lld3) && passed ;
		printTestStatus(passed);
	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
		constructorTest();
	}
} 