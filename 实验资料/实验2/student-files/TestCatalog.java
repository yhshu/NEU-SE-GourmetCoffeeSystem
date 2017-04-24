import  java.io.*;
import  java.util.*;

/**
 * Test driver for class <code>Catalog</code>.
 *
 * @author  iCarnegie
 * @version  1.0.0
 */
public class TestCatalog  {

	/* Standard output stream */
	private static PrintWriter  stdOut =
		new  PrintWriter(System.out, true);

	/* Standard error stream */
	private static PrintWriter  stdErr =
		new  PrintWriter(System.err, true);

	/**
	 * Displays a message in the standard error stream if the value specified
	 * by argument <code>condition<code> is <code>false</code>.
	 *
	 * @param message  the error message.
	 * @param condition  the test condition.
	 */
	public static void assertTrue(String message, boolean condition) {

		if (!condition) {
			stdErr.print("** Test failure ");
			stdErr.println(message);
		}
	}
	
	/**
	 * Displays a message in the standard error stream.
	 *
	 * @param message  the error message.
	 */
	public static void fail(String message) {

		stdErr.print("** Test failure ");
		stdErr.println(message);
	}

	/**
	 * Test driver for class <code>Catalog</code>.
	 *
	 * @param args  not used.
	 */
	public static void  main(String[] args)  {

		stdOut.println("");
		stdOut.println("Testing class Catalog...");

		Product product0 = new Product("P000",
			"product 0", 0.00);
		Product product1 = new Product("P001",
		 	"product 1", 1.00);
		Product product2 = new Product("P002",
			"product 2", 2.00);
		Product product3 = new Product("P003",
			"product 3", 3.00);
		Product[] products = {product0, product1, product2, product3};
		
		Product product4 = new Product("P004",
			"product 4", 4.00);
		Product product5 = new Product("P005",
			"product 5", 5.00);
		Product[] badProducts = {product4, product5};	

		Catalog catalog = new Catalog();
	
		// testing addProduct and getNumberOfProducts
		assertTrue("1: testing method getNumberOfProducts",
			catalog.getNumberOfProducts() == 0);

		for (Product  product : products) {
			catalog.addProduct(product);
		}

		assertTrue("2: testing method getNumberOfProducts",
			catalog.getNumberOfProducts() == products.length);

		// testing getProduct	
		for (Product  product : products) {
			assertTrue("3: testing method getProduct",
				catalog.getProduct(product.getCode()) == product);
		}
			
		for (Product  badProduct : badProducts) {
			assertTrue("4: testing method getProduct",
				catalog.getProduct(badProduct.getCode()) == null);
		}

		// testing iterator
		Iterator<Product> iterator = catalog.iterator();

		for (Product  product : products) {
			if (iterator.hasNext()) {
				assertTrue("5: testing method iterator",
					iterator.next() == product);
			} else {
				fail("6: testing method iterator");
			}
		}

		stdOut.println("done");
	}
}
