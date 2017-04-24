import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

/**
 * This class displays the catalog of the gourmet coffee system.
 *
 * @author author name
 * @version 1.1.0
 * @see Product
 * @see Coffee
 * @see CoffeeBrewer
 * @see Catalog
 * @see CatalogLoader
 * @see FileCatalogLoader
 * @see DataFormatException
 * @see DataField
 */
public class CatalogGUI extends JPanel {

	/* Standar error stream */
	static private PrintWriter  stdErr = new  PrintWriter(System.err, true);

	/* Window width in pixels */
	static private int WIDTH = 420;

	/* Window height in pixels */
	static private int HEIGHT = 320;

	/* Size of the list cell in pixels */
	static private int CELL_SIZE = 50;

	/* Visible rows in list */
	static private int LIST_ROWS = 10;

	/* Rows in status text area */
	static private int STATUS_ROWS = 5;

	/* Rows in status text area */
	static private int STATUS_COLS = 40;

	private JList  catalogList;
	private JPanel productPanel;
	private JTextArea statusTextArea;

	private Catalog  catalog;

	/**
	 * Loads a product catalog and starts the application.
	 *
	 * @param args  String arguments.  Not used.
	 * @throws IOException if there are errors in the loading
	 *                     the catalog.
	 */
	public static void  main(String[]  args) throws IOException {

		String filename = "";

		if (args.length != 1) {
			filename = "catalog.dat";
		} else {
			filename = args[0];
		}
		try {
			Catalog catalog =
				(new FileCatalogLoader()).loadCatalog(filename);

			JFrame frame = new JFrame("Catalog Gourmet Coffee");

			frame.setContentPane(new CatalogGUI(catalog));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(WIDTH, HEIGHT);
			frame.setResizable(true);
			frame.setVisible(true);

		} catch (FileNotFoundException fnfe) {
			stdErr.println("The file does not exist");

			System.exit(1);

		} catch (DataFormatException dfe) {
			stdErr.println("The file contains malformed data: "
			               + dfe.getMessage());

			System.exit(1);
		}
	}

	/**
	 * Instantiates the components and arranges them in a window.
	 *
	 * @param initialCatalog a product catalog.
	 */
	public  CatalogGUI(Catalog initialCatalog) {

		catalog = initialCatalog;

 		// create the components
		catalogList = new JList(catalog.getCodes());
		catalogList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		catalogList.setVisibleRowCount(LIST_ROWS);
		catalogList.setFixedCellWidth(CELL_SIZE);
		statusTextArea = new JTextArea(STATUS_ROWS, STATUS_COLS);
		statusTextArea.setEditable(false);

		// create product information panel
		productPanel = new JPanel();
		productPanel.setBorder(
				BorderFactory.createTitledBorder("Product Information"));

		// create panel to hold list and Display button
		JPanel catalogPanel = new JPanel();
		catalogPanel.setBorder(BorderFactory.createTitledBorder("Catalog"));
		catalogPanel.add (
			new JScrollPane(catalogList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

		setLayout(new BorderLayout());
		add(catalogPanel, BorderLayout.WEST);
		add(productPanel, BorderLayout.CENTER);
		add(statusTextArea, BorderLayout.SOUTH);

		// start listening for list events
		catalogList.addListSelectionListener(new CatalogListListener());
	}

	/*
	 * Obtains a {@link JPanel} object with the information of a product.
	 *
	 * @param dataFields  an {@link ArrayList} of {@link DataField}
	 *                    with the product information.
	 * @return  a {@link JPanel} with the product information.
	 */
	private JPanel getDataFieldsPanel(ArrayList<DataField> dataFields) {


		/* PLACE YOUR CODE HERE */


		return new JPanel(); // REMOVE; USED SO THIS FILE COMPILES

	}

	/**
	 * This inner class handles list-selection events.
	 */
	class CatalogListListener implements ListSelectionListener {

		/**
		 * Displays the information of the selected product.
		 *
		 * @param event  the event object.
		 */
		public void valueChanged(ListSelectionEvent event) {

			String code = (String) catalogList.getSelectedValue();
			Product product = catalog.getProduct(code);

			productPanel.removeAll();
			productPanel.setVisible(false);                   // Use this
			productPanel.add(                                 // to update
				getDataFieldsPanel(product.getDataFields())); // the panel
			productPanel.setVisible(true);                    // correctly

			statusTextArea.setText("Product " + code + " has been displayed");
		}
	}
}