import java.io.*;
import java.util.*;
//import java.text.*;

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
 */
public class GourmetCoffee  {

	private static BufferedReader  stdIn =
		new  BufferedReader(new  InputStreamReader(System.in));
	private static PrintWriter  stdOut = new  PrintWriter(System.out, true);
	private static PrintWriter  stdErr = new  PrintWriter(System.err, true);

	private Sales  sales;

	private SalesFormatter  salesFormatter;

	/**
	 * Loads data into the catalog and starts the application.
	 *
	 * @param args  String arguments.  Not used.
	 * @throws IOException if there are errors in the input.
	 */
	public static void  main(String[]  args) throws IOException  {

		GourmetCoffee  application = new  GourmetCoffee();
		application.run();

	}

	/**
	 * Constructs a <code>GourmetCoffee</code> object and
	 * initializes the catalog and sales data.
	 *
	 * @param initialCatalog a product catalog
	 */
	private GourmetCoffee() {

		this.sales = new Sales();
		this.salesFormatter = 
			PlainTextSalesFormatter.getSingletonInstance();

		loadSales(loadCatalog());
	}

	/**
	 * Creates an empty catalog and then add products to it.
	 *
	 * @return a product catalog
	 */
	private Catalog loadCatalog() {

		Catalog catalog = new Catalog();

		catalog.addProduct(
			new Coffee("C001", "Colombia, Whole, 1 lb", 17.99,
				"Colombia", "Medium", "Rich and Hearty", "Rich",
				"Medium", "Full"));
		catalog.addProduct(
			new Coffee("C002", "Colombia, Ground, 1 lb", 18.75,
				"Colombia", "Medium", "Rich and Hearty", "Rich",
				"Medium","Full"));
		catalog.addProduct(
			new Coffee("C003", "Italian Roasts, Whole, 1 lb",
				16.80, "Latin American Blend", "Italian Roast",
				"Dark and heavy", "Intense", "Low", "Medium"));
		catalog.addProduct(
			new Coffee("C004", "Italian Roasts, Ground, 1 lb",
				17.55, "Latin American Blend", "Italian Roast",
				"Dark and heavy", "Intense", "Low", "Medium"));
		catalog.addProduct(
			new Coffee("C005", "French Roasts, Whole, 1 lb",
				16.80, "Latin American Blend", "French Roast",
				"Bittersweet, full intense", "Intense, full", "None", "Medium"));
		catalog.addProduct(
			new Coffee("C006", "French Roasts, Ground, 1 lb",
				17.55, "Latin American Blend", "French Roast",
				"Bittersweet, full intense", "Intense, full", "None", "Medium"));
		catalog.addProduct(
			new Coffee("C007", "Guatemala, Ground, 1 lb", 17.99,
				"Guatemala", "Medium", "Rich and complex", "Spicy",
				"Medium to high", "Medium to full"));
		catalog.addProduct(
			new Coffee("C008", "Guatemala, Ground, 1 lb", 18.75,
				"Guatemala", "Medium", "Rich and complex", "Spicy",
				"Medium to high", "Medium to full"));
		catalog.addProduct(
			new Coffee("C009", "Guatemala, Whole, 1 lb", 19.99,
				"Sumatra", "Medium", "Vibrant and powdery",
				"Like dark chocolate", "Gentle", "Rich and full"));
		catalog.addProduct(
			new Coffee("C010", "Guatemala, Ground, 1 lb", 20.50,
				"Sumatra", "Medium", "Vibrant and powdery",
				"Like dark chocolate", "Gentle", "Rich and full"));
		catalog.addProduct(
			new Coffee("C011", "Special Blend, Whole, 1 lb",
				16.80, "Latin American Blend", "Dark roast",
				"Full, roasted flavor", "Hearty", "Bold and rich", "Full"));
		catalog.addProduct(
			new Coffee("C012", "Special Blend, Ground, 1 lb",
				17.55, "Latin American Blend", "Dark roast",
				"Full, roasted flavor", "Hearty", "Bold and rich", "Full"));

		catalog.addProduct(
			new CoffeeBrewer("B001", "Home Coffee Brewer",
				150.00, "Brewer 100", "Pourover", 6));
		catalog.addProduct(
			new CoffeeBrewer("B002", "Coffee Brewer, 2 Warmers",
				200.00, "Brewer 200", "Pourover", 12));
		catalog.addProduct(
			new CoffeeBrewer("B003", "Coffee Brewer, 3 Warmers",
				280.00, "Brewer 210", "Pourover", 12));
		catalog.addProduct(
			new CoffeeBrewer("B004", "Commercial Brewer, 20 cups",
				380.00, "Quick Coffee 100", "Automatic", 20));
		catalog.addProduct(
			new CoffeeBrewer("B005", "Commercial Brewer, 40 cups",
				480.00, "Quick Coffee 200", "Automatic", 40));

		catalog.addProduct(
			new Product("A001", "Almond Flavored Syrup", 9.00));
		catalog.addProduct(
			new Product("A002", "Irish Creme Flavored Syrup", 9.00));
		catalog.addProduct(
			new Product("A003", "Mint Flavored syrup", 9.00));
		catalog.addProduct(
			new Product("A004", "Caramel Flavored Syrup", 9.00));
		catalog.addProduct(
			new Product("A005", "Gourmet Coffee Cookies", 12.00));
		catalog.addProduct(
			new Product("A006", "Gourmet Coffee Travel Thermo", 18.00));
		catalog.addProduct(
			new Product("A007", "Gourmet Coffee Ceramic Mug", 8.00));
		catalog.addProduct(
			new Product("A008", "Gourmet Coffee 12 Filters", 15.00));
		catalog.addProduct(
			new Product("A009", "Gourmet Coffee 36 Filters", 45.00));

		return catalog;
	}

	/**
	 * Initializes the sales object.
	 */
	private void loadSales(Catalog catalog) {

		Order orderOne = new Order();

		orderOne.addItem(new OrderItem(catalog.getProduct("C001"), 5));
		this.sales.addOrder(orderOne);

		Order orderTwo = new Order();

		orderTwo.addItem(new OrderItem(catalog.getProduct("C002"), 2));
		orderTwo.addItem(new OrderItem(catalog.getProduct("A001"), 2));
		this.sales.addOrder(orderTwo);

		Order orderThree = new Order();

		orderThree.addItem(new OrderItem(catalog.getProduct("B002"), 1));
		this.sales.addOrder(orderThree);
	}

	/**
	 * Displays a menu of options and verifies the user's choice.
	 *
	 * @return an integer in the range [0,3]
	 */
	private int  getChoice() throws IOException  {

		int  input;

		do  {
			try  {
				stdErr.println();
				stdErr.print("[0]  Quit\n"
				             + "[1]  Display sales (Plain Text)\n"
				             + "[2]  Display sales (HTML)\n"
				             + "[3]  Display sales (XML)\n"
				             + "choice> ");
				stdErr.flush();

				input = Integer.parseInt(stdIn.readLine());

				stdErr.println();

				if (0 <= input && 3 >= input)  {
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
	 * Changes the sales formatter.
	 *
	 * @param newFormatter a sales formatter
	 */
	private void setSalesFormatter(SalesFormatter newFormatter){

		/* PLACE YOUR CODE HERE */
	}

	/**
	 * Displays the sales information in the current format.
	 */
	private void displaySales() {

		/* PLACE YOUR CODE HERE */
	}

	/**
	 * Presents the user with a menu of options and executes the
	 * selected task.
	 */
	private void run() throws IOException  {

		int  choice = getChoice();

		while (choice != 0)  {

			if (choice == 1)  {

				/* PLACE YOUR CODE HERE */

			} else if (choice == 2)  {

				/* PLACE YOUR CODE HERE */

			} else if (choice == 3)  {

				/* PLACE YOUR CODE HERE */

			}

			choice = getChoice();
		}
	}
}