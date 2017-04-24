import  java.io.*;

/**
 * Test driver for class <code>CoffeeBrewer</code>.
 *
 * @author  iCarnegie
 * @version  1.0.0
 */
public class TestCoffeeBrewer  {

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
	 * Test driver for class <code>CoffeeBrewer</code>.
	 *
	 * @param args  not used.
	 */
	public static void  main(String[] args)  {

		stdOut.println("");
		stdOut.println("Testing class CoffeeBrewer...");

		String code = "B001";
		String description = "Home Coffee Brewer";
		double price = 150.0;
		String model = "Brewer 100";
		String waterSupply = "Pourover";
		int numberOfCups = 6;

		// Test accessors
		CoffeeBrewer product = new CoffeeBrewer(code, description, price, model,
		                                        waterSupply, numberOfCups);

		assertTrue("1: testing method getModel",
		           model.equals(product.getModel()));
		assertTrue("2: testing method getWaterSupply",
		           waterSupply.equals(product.getWaterSupply()));
		assertTrue("3: testing method getNumberOfCups",
		           numberOfCups == product.getNumberOfCups());

		// Test method toString
		product = new CoffeeBrewer(code, description, price, model,
		                           waterSupply, numberOfCups);
		String result = code + "_" + description + "_" + price + "_"
		                + model + "_" + waterSupply + "_" + numberOfCups;

		assertTrue("4: testing method toString",
		           result.equals(product.toString()));

		stdOut.println("done");
	}
}
