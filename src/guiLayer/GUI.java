package guiLayer;
import java.awt.*;
import javax.swing.*;

class GUI extends JFrame{
	
	static JFrame frame;
	static JPanel panel;
	
	public GUI() {
		init();
	}

	public void init() {
		//Creating the Frame
		JFrame frame = new JFrame("Western Style - Internal Management Software");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);

		//Create menu bar
		JMenuBar menuBar = new JMenuBar();


		//Add Customer menu and options
		JMenu menuCustomer = new JMenu("Customers");
		menuBar.add(menuCustomer);
		JMenuItem menuOptionCreateCustomer = new JMenuItem(new OpenCreateCustomerPage(frame, "Create customer"));
		JMenuItem menuOptionReadCustomer = new JMenuItem(new OpenReadCustomerPage(frame,"List customers"));
		JMenuItem menuOptionEditCustomer = new JMenuItem(new OpenEditCustomerPage(frame, "Edit customer"));
		JMenuItem menuOptionDeleteCustomer = new JMenuItem(new OpenDeleteCustomerPage(frame, "Delete customer"));
		menuCustomer.add(menuOptionCreateCustomer);
		menuCustomer.add(menuOptionReadCustomer);
		menuCustomer.add(menuOptionEditCustomer);
		menuCustomer.add(menuOptionDeleteCustomer);

		//Add Product menu and options
		JMenu menuProduct = new JMenu("Products");
		menuBar.add(menuProduct);
		JMenuItem menuOptionCreateProduct = new JMenuItem(new OpenCreateProductPage(frame, "Create product"));
		JMenuItem menuOptionReadProduct = new JMenuItem(new OpenReadProductPage(frame, "List products"));
		JMenuItem menuOptionEditProduct = new JMenuItem(new OpenEditProductPage(frame, "Edit product"));
		JMenuItem menuOptionDeleteProduct = new JMenuItem(new OpenDeleteProductPage(frame,"Delete product"));
		menuProduct.add(menuOptionCreateProduct);
		menuProduct.add(menuOptionReadProduct);
		menuProduct.add(menuOptionEditProduct);
		menuProduct.add(menuOptionDeleteProduct);

		//Add Orders menu and options
		JMenu menuOrder = new JMenu("Orders");
		menuBar.add(menuOrder);
		JMenuItem menuCreateOrder = new JMenuItem("Create order");
		menuOrder.add(menuCreateOrder);

		//Adding components and launching the app
		frame.add(BorderLayout.NORTH, menuBar);
		frame.setVisible(true);
	}


}


