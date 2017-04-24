import  java.io.*;

/**
 * Test driver for class <code>OrderItem</code>.
 *
 * @author  iCarnegie
 * @version  1.0.0
 * @see OrderItem
 * @see Product
 */
public class TestOrderItem  {

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
	 * Test driver for class <code>OrderItem</code>.
	 *
	 * @param args  not used.
	 */
	public static void  main(String[] args)  {

		stdOut.println("");
		stdOut.println("Testing class OrderItem...");

		String code = "C001";
		String description = "Colombia, Whole, 1 lb";
		double price = 17.99;
		int quantity = 5;
		int newQuantity = 10;
		Product product = new Product(code, description, price);

		// Test accessors
		OrderItem item = new OrderItem(product, quantity);

		assertTrue("1: testing method getProduct",
		           product.equals(item.getProduct()));
		assertTrue("2: testing method getQuantity",
		           quantity == item.getQuantity());

		// Test mutator
		item = new OrderItem(product, quantity);
		item.setQuantity(newQuantity);

		assertTrue("3: testing method setQuantity",
		           newQuantity == item.getQuantity());

		// Test method valueOf
		item = new OrderItem(product, quantity);

		double value = price * (double) quantity;

		assertTrue("4: testing method valueOf",
		           value == item.getValue());

		// Test method toString
		item = new OrderItem(product, quantity);

		String result = quantity + " " + code + " " + price;

		assertTrue("5: testing method toString",
		           result.equals(item.toString()));

		stdOut.println("done");
	}
}
