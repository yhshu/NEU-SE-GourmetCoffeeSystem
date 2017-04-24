import  java.io.*;
import  java.util.*;

/**
 * Test driver for class <code>Sales</code>.
 *
 * @author  iCarnegie
 * @version  1.0.0
 */
public class TestSales  {

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
	 */
	public static void assertTrue(String message, boolean condition) {

		if (! condition) {
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
	 * Test driver for class <code>Sales</code>.
	 *
	 * @param args  not used.
	 */
	public static void  main(String[] args)  {

		stdOut.println("");
		stdOut.println("Testing class Sales...");

		Product product0 = new Product("P000",
			"product 0", 0.00);
		Product product1 = new Product("P001",
		 	"product 1", 1.00);
		Product product2 = new Product("P002",
			"product 2", 2.00);
		Product product3 = new Product("P003",
			"product 3", 3.00);
		OrderItem item0 = new OrderItem(product0, 1);
		OrderItem item1 = new OrderItem(product1, 2);
		OrderItem item2 = new OrderItem(product2, 3);
		OrderItem item3 = new OrderItem(product3, 4);
		OrderItem item4 = new OrderItem(product0, 5);

		Order order0 = new Order();
		order0.addItem(item0);
		order0.addItem(item1);

		Order order1 = new Order();
		order1.addItem(item2);
		order1.addItem(item3);

		Order order2 = new Order();
		order2.addItem(item4);

		Order[] orders = {order0, order1, order2};

		Sales sales = new Sales();

		// Testing addOrder and getNumberOfOrders
		assertTrue("1: testing method getNumberOfOrders",
			sales.getNumberOfOrders() == 0);

		for (int i = 0; i < orders.length; i++) {
			sales.addOrder(orders[i]);
		}

		assertTrue("2: testing method getNumberOfOrders",
			sales.getNumberOfOrders() == orders.length);

		// testing iterator
		Iterator<Order> iterator = sales.iterator();

		for (Order order : orders) {
			if (iterator.hasNext()) {
				assertTrue("3: testing method iterator",
					iterator.next() == order);
			} else {
				fail("4: testing method iterator");
			}
		}

		stdOut.println("done");
	}
}
