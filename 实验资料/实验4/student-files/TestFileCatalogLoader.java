import java.io.*;
import java.util.*;

/**
 * Tests the class <code>FileCatalogLoader</code>
 *
 * @author iCarnegie
 * @version 1.0.0
 * @see FileCatalogLoader
 */
public class  TestFileCatalogLoader  {

	/* Standard output stream */
	private static PrintWriter  stdOut = new  PrintWriter(System.out, true);

	/* Standard error stream */
	private static PrintWriter  stdErr = new  PrintWriter(System.err, true);

	/**
	 * Tests methods of class {@link FileCatalogLoader}
	 *
	 * @param args  not used.
	 * @throws IOException  if an I/O error occurs.
	 */
	public static void main (String args[]) throws IOException {

		stdOut.println("");
		stdOut.println("Testing class FileCatalogLoader...");

		TestFileCatalogLoader tester =
			new TestFileCatalogLoader();

		tester.testLoadCatalog();
		stdOut.println("All tests passed");
		stdOut.println("");
	}

	/**
	 * Displays a message in the standard error stream if the value specified
	 * by parameter <code>condition<code> is <code>false</code>.
	 *
	 * @param message  the error message.
	 * @param condition  the test condition.
	 * @return the value of <code>condition</code>
	 */
	public static void assertTrue(String message, boolean condition) {

		if (!condition) {
			stdErr.print("** Test failure ");
			stdErr.println(message);

			System.exit(1);
		}

	}
	
	/**
	 * Displays a message in the standard error stream.
	 *
	 * @param message  the error message.
	 * @return <code>false</code>;
	 */
	public static void fail(String message) {

		stdErr.print("** Test failure ");
		stdErr.println(message);

		System.exit(1);
	}

	/**
	 * Tests the method <code>loadCatalog</code>.
	 *
	 * @return <code>true</code> if all test passed; otherwise returns
	 *         <code>false</code>.
	 * @throws IOException  if an I/O error occurs.
	 */
	public void testLoadCatalog() throws IOException {

		CatalogLoader loader = new FileCatalogLoader();
			
		try {
			// Testing an empty file
			Catalog emptyCatalog =
				loader.loadCatalog("empty.dat");
				
			assertTrue("1, testing method read with an empty file",
				emptyCatalog instanceof Catalog);
			assertTrue("2, testing method read with an empty file"
				+ emptyCatalog.getNumberOfProducts() + " products loaded",
				emptyCatalog.getNumberOfProducts() == 0);
			
			// Testing a not empty file
			Catalog catalog =
				loader.loadCatalog("catalog.dat");
	
			assertTrue("3, testing method loadCatalog",
				catalog instanceof Catalog);
			assertTrue("4, testing method loadCatalog: "
				+ catalog.getNumberOfProducts() + " products loaded",
				catalog.getNumberOfProducts() == 26);
			
			// Testing product C001
			Product product = catalog.getProduct("C001");
			
			assertTrue("5, testing method loadCatalog" + product.toString(),
				product instanceof Coffee);
			
			Coffee coffeeC001 = (Coffee) product;
				
			assertTrue("6, testing method loadCatalog: " + 
				coffeeC001.toString(),
				coffeeC001.getCode().equals("C001") &&
				coffeeC001.getDescription().equals("Colombia, Whole, 1 lb") &&
				coffeeC001.getPrice() == 17.99 &&
				coffeeC001.getOrigin().equals("Colombia") &&
				coffeeC001.getRoast().equals("Medium") &&
				coffeeC001.getFlavor().equals("Rich and Hearty")  &&
				coffeeC001.getAroma().equals("Rich") &&
				coffeeC001.getAcidity().equals("Medium") &&
				coffeeC001.getBody().equals("Full"));
			
			// Testing product C002
			product = catalog.getProduct("C002");
			
			assertTrue("7, testing method loadCatalog: " + product.toString(),
				product instanceof Coffee);
			
			Coffee coffeeC002 = (Coffee) product;
				
			assertTrue("8, testing method loadCatalog: " + 
				coffeeC002.toString(),
				coffeeC002.getCode().equals("C002") &&
				coffeeC002.getDescription().equals("Colombia, Ground, 1 lb") &&
				coffeeC002.getPrice() == 18.75 &&
				coffeeC002.getOrigin().equals("Colombia") &&
				coffeeC002.getRoast().equals("Medium") &&
				coffeeC002.getFlavor().equals("Rich and Hearty")  &&
				coffeeC002.getAroma().equals("Rich") &&
				coffeeC002.getAcidity().equals("Medium") &&
				coffeeC002.getBody().equals("Full"));
				
			// Testing product A001
			product = catalog.getProduct("A001");
			
			assertTrue("9, testing method loadCatalog: " + product.toString(),
				product instanceof Product);
				
			assertTrue("10, testing method loadCatalog: " + 
				product.toString(),
				product.getCode().equals("A001") &&
				product.getDescription().equals("Almond Flavored Syrup") &&
				product.getPrice() == 9.0);
				
			// Testing product B002
			product = catalog.getProduct("B002");
			
			assertTrue("11, testing method loadCatalog: " + product.toString(),
				product instanceof CoffeeBrewer);
	
			CoffeeBrewer brewerB002 = (CoffeeBrewer) product;
			
			assertTrue("12, testing method loadCatalog: " + 
				brewerB002.toString(),
				brewerB002.getCode().equals("B002") &&
				brewerB002.getDescription().equals("Coffee Brewer, 2 Warmers") &&
				brewerB002.getPrice() == 200.0 &&
				brewerB002.getModel().equals("Brewer 200") &&
				brewerB002.getWaterSupply().equals("Pourover") &&
				brewerB002.getNumberOfCups() == 12);
				
		} catch (Exception e) {
			fail("13, testing method loadCatalog: " + e.getMessage());
		}
	}
}