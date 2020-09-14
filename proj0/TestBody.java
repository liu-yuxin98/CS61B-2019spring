/* write my own testbody program*/
public class TestBody {
	public static void main(String[] args){
		checkcalcForceExertedBy();
		}

	/**
     *  Checks whether or not two Doubles are equal and prints the result.
     *
     *  @param  expected    Expected double
     *  @param  actual      Double received
     *  @param  label       Label for the 'test' case
     *  @param  eps         Tolerance for the double comparison.
     */
    private static void checkEquals(double actual, double expected, String label, double eps) {
        if (Double.isNaN(actual) || Double.isInfinite(actual)) {
            System.out.println("FAIL: " + label
                    + ": Expected " + expected + " and you gave " + actual);
        } else if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("PASS: " + label
                    + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label
                    + ": Expected " + expected + " and you gave " + actual);
        }
    }


	/**
     *  Checks the Body class to make sure calcForceExertedBy works.
     */
    private static void checkcalcForceExertedBy() {
        System.out.println("Checking calcDistance...");

        Body b1 = new Body(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Body b2 = new Body(2.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Body b3 = new Body(4.0, 5.0, 3.0, 4.0, 5.0, "jupiter.gif");

        checkEquals(b1.calcDistance(b2), 1.0, "calcDistance()", 0.01);
        checkEquals(b1.calcDistance(b3), 5.0, "calcDistance()", 0.01);
    }	


	}