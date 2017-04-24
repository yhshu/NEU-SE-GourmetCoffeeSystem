import  java.io.*;
import  java.util.*;

/**
 * Test driver for class <code>Order</code>.
 *
 * @author  iCarnegie
 * @version  1.0.0
 */
public class TestOrder  {

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
	 * Test driver for class <code>Order</code>.
	 *
	 * @param args  not used.
	 */
	public static void  main(String[] args)  {

		stdOut.println("");
		stdOut.println("Testing class Order...");

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

		Product[] products = {product0, product1, product2, product3};
		OrderItem[] items = {item0, item1, item2, item3};
		OrderItem[] removedItems = {item0, item3};
		OrderItem[] notRemovedItems = {item1, item2};

		Product product4 = new Product("P004",
			"product 4", 4.00);
		Product product5 = new Product("P005",
			"product 5", 5.00);
		Product[] badProducts = {product4, product5};	

		Order order = new Order();

		// Testing addItem and getNumberOfItems
		assertTrue("1: testing method getNumberOfItems",
			order.getNumberOfItems() == 0);

		for (OrderItem  item : items) {
			order.addItem(item);
		}

		assertTrue("2: testing method getNumberOfItems",
			order.getNumberOfItems() == items.length);
		
		// testing getItem
		for (int i = 0; i <  items.length; i++) {
			assertTrue("3: testing method getItem",
				order.getItem(products[i]) == items[i]);
		}
			
		for (Product  badProduct : badProducts) {
			assertTrue("4: testing method getItem",
				order.getItem(badProduct) == null);
		}

		// testing getTotalCost
		double result = 0.0;	
		for (OrderItem  item : items) {
			result += item.getValue();
		}
		assertTrue("5: testing method getTotalCost",
			order.getTotalCost() == result);

		// testing iterator
		Iterator<OrderItem> iterator = order.iterator();
		
		for (OrderItem  item : items) {
			if (iterator.hasNext()) {
				assertTrue("6: testing method iterator",
					iterator.next() == item);
			} else {
				fail("7: testing method iterator");
			}
		}

		// testing removeItems
		for (OrderItem  removedItem : removedItems) {
			order.removeItem(removedItem);
		}

		assertTrue("8: testing method removeItems",
			order.getNumberOfItems() == notRemovedItems.length);

		for (OrderItem  notRemovedItem : notRemovedItems) {
			assertTrue("9: testing method removeItems",
				order.getItem(notRemovedItem.getProduct()) ==
					notRemovedItem);
		}

		for (OrderItem  removedItem : removedItems) {
			assertTrue("10: testing method removeItems",
				order.getItem(removedItem.getProduct()) == null);
		}

		stdOut.println("done");
	}
}
