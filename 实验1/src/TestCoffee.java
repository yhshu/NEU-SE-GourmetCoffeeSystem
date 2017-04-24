import  java.io.*;

/**
 * Test driver for class <code>Coffee</code>.
 *
 * @author  iCarnegie
 * @version  1.0.0
 * @see Coffee
 */
public class TestCoffee  {

	/* Standard output stream */
	private static PrintWriter  stdOut = new  PrintWriter(System.out, true);

	/* Standard error stream */
	private static PrintWriter  stdErr = new  PrintWriter(System.err, true);

	/**
	 * Displays a message in the standard error stream if the value specified
	 * by parameter <code>condition<code> is <code>false</code>.
	 *
	 * @param message  the error message.
	 * @param condition  the test condition.
	 */
	public static void assertTrue(String message, boolean condition) {

		if (! condition) {
			stdErr.print("** Test failure ");
			stdErr.println(message);

		}
	}

	/**
	 * Test driver for class <code>Coffee</code>.
	 *
	 * @param args  not used.
	 */
	public static void  main(String[] args)  {

		stdOut.println("");
		stdOut.println("Testing class Coffee...");
		
		String code = "C001";
		String description = "Colombia, Whole, 1 lb";
		double price = 17.99;
		String origin = "Colombia";
		String roast = "Medium";
		String flavor = "Rich and Hearty";
		String aroma = "Rich";
		String acidity = "Medium";
		String body = "Full";

		Coffee product = new Coffee(code, description, price, origin, roast,
		                            flavor, aroma, acidity, body);

		// Test accessors
		assertTrue("1: testing method getOrigin",
		           origin.equals(product.getOrigin()));
		assertTrue("2: testing method getRoasted",
		           roast.equals(product.getRoast()));
		assertTrue("3: testing method getFlavor",
		           flavor.equals(product.getFlavor()));
		assertTrue("4: testing method getAroma",
		           aroma.equals(product.getAroma()));
		assertTrue("5: testing method getAcidity",
		           acidity.equals(product.getAcidity()));
		assertTrue("6: testing method getBody",
		           body.equals(product.getBody()));

		// Test method toString
		product = new Coffee(code, description, price, origin, roast,
		                     flavor, aroma, acidity, body);

		String result = code + "_" + description + "_" + price + "_" + origin
		                + "_" + roast + "_" + flavor + "_" + aroma + "_"
		                + acidity + "_" + body;

		assertTrue("7: testing method toString",
		           result.equals(product.toString()));

		stdOut.println("done");
	}
}
