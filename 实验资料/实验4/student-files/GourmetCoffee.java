import java.io.*;
import java.util.*;
import java.text.*;

/**
 * This class implements a gourmet coffee system.
 *
 * @author author name
 * @version 1.1.0
 * @see Product
 * @see Coffee
 * @see CoffeeBrewer
 * @see Catalog
 * @see OrderItem
 * @see Order
 * @see SalesFormatter
 * @see PlainTextSalesFormatter
 * @see HTMLSalesFormatter
 * @see XMLSalesFormatter
 * @see CatalogLoader
 * @see FileCatalogLoader
 */
public class GourmetCoffee  {

	private static BufferedReader  stdIn =
		new  BufferedReader(new  InputStreamReader(System.in));
	private static PrintWriter  stdOut = new  PrintWriter(System.out, true);
	private static PrintWriter  stdErr = new  PrintWriter(System.err, true);

	private Catalog  catalog;
	private Sales  sales;

	private SalesFormatter salesFormatter;

	/**
	 * Loads catalog data from a file and starts the application.
	 * <p>
	 * The name of the file is specified in the command arguments.
	 * </p>
	 *
	 * @param args  String arguments.
	 * @throws IOException if there are errors in the input.
	 */
	public static void  main(String[]  args) throws IOException  {

		Catalog catalog = null;

		if (args.length != 1) {
			stdErr.println("Usage: java GourmetCoffee filename");
		} else {
			try {
				catalog =
					(new FileCatalogLoader()).loadCatalog(args[0]);
			} catch (FileNotFoundException fnfe) {
				stdErr.println("The file does not exist");

				System.exit(1);

			} catch (DataFormatException dfe) {
				stdErr.println("The file contains malformed data: "
				               + dfe.getMessage());

				System.exit(1);
			}

			GourmetCoffee  application =
				new GourmetCoffee(catalog);

			application.run();
		}
	}

	/**
	 * Constructs a <code>GourmetCoffee</code> object.
	 * Initializes the catalog data with the value specified
	 * in the parameter.
	 *
	 * @param initialCatalog a product catalog
	 */
	private GourmetCoffee(Catalog initialCatalog) {

		this.catalog = initialCatalog;
		this.sales = new Sales();
		this.salesFormatter =
			PlainTextSalesFormatter.getSingletonInstance();

		loadSales();
	}

	/**
	 * Initializes the sales object.
	 */
	private void loadSales() {

		Order orderOne = new Order();
		Product productOne = this.catalog.getProduct("C001");
		
		if (productOne != null) {
			orderOne.addItem(new OrderItem(productOne, 5));
			this.sales.addOrder(orderOne);
		}

		Order orderTwo = new Order();
		Product productTwo = this.catalog.getProduct("C002");
		Product productThree = this.catalog.getProduct("A001");

		if ((productTwo != null) && (productThree != null)) {
			orderTwo.addItem(new OrderItem(productTwo, 2));
			orderTwo.addItem(new OrderItem(productThree, 2));
			this.sales.addOrder(orderTwo);
		}

		Order orderThree = new Order();
		Product productFour = this.catalog.getProduct("B002");

		if (productFour != null) {
			orderThree.addItem(new OrderItem(productFour, 1));
			this.sales.addOrder(orderThree);
		}
	}

	/**
	 * Presents the user with a menu of options and executes the
	 * selected task.
	 */
	private void run() throws IOException  {

		int  choice = getChoice();

		while (choice != 0)  {
			if (choice == 1)  {
				displayCatalog();
			} else if (choice == 2)  {
				this.salesFormatter =
					PlainTextSalesFormatter.getSingletonInstance();
				writeFile(
					readFilename(),
					this.salesFormatter.formatSales(this.sales));
			} else if (choice == 3)  {
				this.salesFormatter =
					HTMLSalesFormatter.getSingletonInstance();
				writeFile(
					readFilename(),
					this.salesFormatter.formatSales(this.sales));
			} else if (choice == 4)  {
				this.salesFormatter =
					XMLSalesFormatter.getSingletonInstance();
				writeFile(
					readFilename(),
					this.salesFormatter.formatSales(this.sales));
			}

			choice = getChoice();
		}
	}

	/**
	 * Displays a menu of options and verifies the user's choice.
	 *
	 * @return an integer in the range [0,7]
	 */
	private int  getChoice() throws IOException  {

		int  input;

		do  {
			try  {
				stdErr.println();
				stdErr.print("[0]  Quit\n"
				             + "[1]  Display Catalog\n"
				             + "[2]  Save sales (Plain Text)\n"
				             + "[3]  Save sales (HTML)\n"
				             + "[4]  Save sales (XML)\n"
				             + "choice> ");
				stdErr.flush();

				input = Integer.parseInt(stdIn.readLine());

				stdErr.println();

				if (0 <= input && 4 >= input)  {
					break;
				} else {
					stdErr.println("Invalid choice:  " + input);
				}
			} catch (NumberFormatException  nfe)  {
				stdErr.println(nfe);
			}
		}  while (true);

		return  input;
	}

	/**
	 * Displays the catalog.
	 */
	private void displayCatalog() {

		int size = this.catalog.getNumberOfProducts();

		if (size == 0) {
			stdErr.println("The catalog is empty");
		} else {
			for (Product product : this.catalog) {
				stdOut.println(product.getCode() + " "
				               + product.getDescription());
			}
		}
	}

	/**
	 * Creates a new file (which has the specified name) and writes
	 * the specified string to the new file.
	 *
	 * @param filename name of the file that will store the data
	 * @param content data to be stored
	 */
	private void writeFile(String filename, String content)
		throws IOException {

		/* PLACE YOUR CODE HERE */
		
	}

	/**
	 * Prompts the user for a filename (the name of the file that
	 * will store the sales information) and returns the user's
	 * response.
	 *
	 * @return name of a file
	 */
	private  String readFilename() throws IOException  {

		stdErr.print("Filename> ");
		stdErr.flush();

		return stdIn.readLine();
	}
}