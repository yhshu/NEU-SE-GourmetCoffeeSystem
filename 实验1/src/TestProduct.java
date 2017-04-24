import  java.io.*;

/**
 * Test driver for class <code>Product</code>.
 *
 * @author  iCarnegie
 * @version  1.0.0
 * @see Product
 */
public class TestProduct  {

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
	 * Test driver for class <code>Product</code>.
	 *
	 * @param args  not used.
	 */
	public static void  main(String[] args)  {

		stdOut.println("");
		stdOut.println("Testing class Product...");

		String code = "C001";
		String description = "Colombia, Whole, 1 lb";
		double price = 10.0;

		// Test accessors
		Product product = new Product(code, description, price);

		assertTrue("1: testing method getCode",
		           code.equals(product.getCode()));
		assertTrue("2: testing method getDescription",
		           description.equals(product.getDescription()));
		assertTrue("3: testing method getPrice",
		           price == product.getPrice());

		// Test method equals
		String codeOne = "C001";
		String descriptionOne = "Colombia, Whole, 1 lb";
		double priceOne= 17.99;

		String codeTwo = "B111";
		String descriptionTwo = "Home Coffee Brewer";
		double priceTwo= 150.00;

		Product productOne = new Product(codeOne, descriptionOne, priceOne);
		Product productTwo = new Product(codeOne, descriptionTwo, priceTwo);
		Product productThree = new Product(codeTwo, descriptionTwo, priceTwo);

		assertTrue("4: testing method equals",
		           productOne.equals(productTwo));
		assertTrue("5: testing method equals",
		           !productOne.equals(productThree));
		assertTrue("6: testing method equals",
		           !productOne.equals("Product"));

		// Test method toString
		product = new Product(code, description, price);
		String result = code + "_" + description + "_" + price;

		assertTrue("7: testing method toString",
		           result.equals(product.toString()));

		stdOut.println("done");
	}
}
