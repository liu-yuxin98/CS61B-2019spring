public class ArrayDequeTest {
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
    public static boolean checkconstructor(ArrayDeque expected,ArrayDeque actual){
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
        /* check isempty*/
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        boolean passed = checkEmpty(true,ad1.IsEmpty());
        /* check size addfirst*/
        ad1.addfirst(2);
        passed = checkSize(1,ad1.size())&&passed;
        /* check addfirst*/
        ad1.addfirst(3);
        passed = (ad1.get(0)==3)&& passed;
        /* check add last*/
        ad1.addlast(4);
        passed = (ad1.get(2)==4)&& passed;
        printTestStatus(passed);

    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");
        /* check addfirst*/
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        ad1.addlast(1);
        ad1.addlast(2);
        boolean passed = (ad1.removelast() ==2);
        ad1.removelast();
        passed = checkSize(0,ad1.size())&&passed;
        printTestStatus(passed);
    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void constructorTest() {
        System.out.println("Running constructor test.");
        /* empty constructor*/
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        boolean passed = checkEmpty(true,ad1.IsEmpty());
        ad1.addlast(1);
        ad1.addlast(2);
        /* copy ocnstructor*/
        ArrayDeque<Integer> ad2 = new ArrayDeque<>(ad1);
        passed = checkconstructor(ad1,ad2) && passed ;
        printTestStatus(passed);
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
        constructorTest();
    }
}
