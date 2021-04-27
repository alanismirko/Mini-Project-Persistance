package guiLayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controllerLayer.CustomerController;
import controllerLayer.DataAccessException;
import controllerLayer.ProductController;
import guiLayer.OpenCreateProductPage.CreateProductPage;
import guiLayer.OpenEditCustomerPage.EditCustomerPage;
import modelLayer.Product;


public class OpenEditProductPage extends AbstractAction {
	JFrame frame;
	String text;
	EditProductPage editProductPage;
	ProductController productController;

	public OpenEditProductPage(JFrame frame, String text){
		super(text);
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		editProductPage = new EditProductPage(frame, text);
		try {
			productController = new ProductController();
		} catch (DataAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		findCustomerByName();
	}


	private void findCustomerByName() {
		String string = (String)JOptionPane.showInputDialog(frame, "First name of the product to edit:", "", JOptionPane.PLAIN_MESSAGE);

		//If a string was returned, say so.
		if ((string != null) && (string.length() > 0)) {
		    try {
		    	System.out.println(string);
		    	editProductPage.setProductToEdit(productController.findProductByProductID(Integer.parseInt(string), false));;
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return;
		}
	}



	public class EditProductPage extends JFrame {

		JFrame frame;
		Container mainPanel;
		Container middlePanel;
		ProductController productController;
		Product productToEdit;
		String name;
		Double purchasePrice;
		Double salePrice;
		Double rentPrice;
		String countryOrigin;
		Integer minStock;
		Integer maxStock;
		JTextField fieldProductName;        
        JTextField fieldPurchasePrice;
        JTextField fieldSalePrice;
        JTextField fieldRentPrice;
        JTextField fieldCountryOrigin;
        JTextField fieldMinStock;
        JTextField fieldMaxStock;
        
        public void setProductToEdit(Product product) {
        	productToEdit = product;
        }
		


		public EditProductPage(JFrame frame, String texte){

			super(texte);
			this.frame = frame;
			frame.repaint();
			this.mainPanel = frame.getContentPane();
			mainPanel.removeAll();
			middlePanel = new Container();
			
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
			JMenuItem menuCreateOrder = new JMenuItem(new OpenCreateOrderPage(frame,"Create order"));
			menuOrder.add(menuCreateOrder);

			//Adding components and launching the app
			frame.add(BorderLayout.NORTH, menuBar);

			//mainPanel.setBackground(Color.white);
			BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
			//mainPanel.setLayout(boxLayout);
			middlePanel.setLayout(new FlowLayout());

			// Define new buttons with different width on help of the ---
	        JLabel labelProductName = new JLabel("Name");        
	        JLabel labelPurchasePrice = new JLabel("Purchase price");
	        JLabel labelSalePrice = new JLabel("Sale price");
	        JLabel labelRentPrice = new JLabel("Rent price");
	        JLabel labelCountryOrigin = new JLabel("Country of origin");
	        JLabel labelMinStock = new JLabel("Min. stock");
	        JLabel labelMaxStock = new JLabel("Max. stock");
	        fieldProductName = new JTextField("TestProductName");        
	        fieldPurchasePrice = new JTextField("10");
	        fieldSalePrice = new JTextField("20");
	        fieldRentPrice = new JTextField("15");
	        fieldCountryOrigin = new JTextField("Neverland");
	        fieldMinStock = new JTextField("1");
	        fieldMaxStock = new JTextField("100");

	         
	        // Define the panel to hold the buttons 
	        JPanel panel1 = new JPanel();
	        panel1.removeAll();
	        panel1.updateUI();
	        JPanel panel2 = new JPanel();
	        panel2.removeAll();
	        panel2.updateUI();
	 

	        // Set up the BoxLayout
	        BoxLayout layout1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
	        BoxLayout layout2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
	        panel1.setLayout(layout1);
	        panel2.setLayout(layout2);
	         
	        // Add the buttons into the panel with two different alignment options
	        EmptyBorder border = new EmptyBorder(2, 0, 2, 0);
	        
	        labelProductName.setAlignmentX(Component.LEFT_ALIGNMENT);
	        labelProductName.setAlignmentY(Component.LEFT_ALIGNMENT);
	        labelProductName.setBorder(border);
	        
	        labelPurchasePrice.setAlignmentX(Component.LEFT_ALIGNMENT);
	        labelPurchasePrice.setAlignmentY(Component.LEFT_ALIGNMENT);
	        labelPurchasePrice.setBorder(border);
	        
	        labelSalePrice.setAlignmentX(Component.LEFT_ALIGNMENT);
	        labelSalePrice.setAlignmentY(Component.LEFT_ALIGNMENT);
	        labelSalePrice.setBorder(border);
	        
	        labelRentPrice.setAlignmentX(Component.LEFT_ALIGNMENT);
	        labelRentPrice.setAlignmentY(Component.LEFT_ALIGNMENT);
	        labelRentPrice.setBorder(border);
	        
	        labelCountryOrigin.setAlignmentX(Component.LEFT_ALIGNMENT);
	        labelCountryOrigin.setAlignmentY(Component.LEFT_ALIGNMENT);
	        labelCountryOrigin.setBorder(border);
	        
	        labelMinStock.setAlignmentX(Component.LEFT_ALIGNMENT);
	        labelMinStock.setAlignmentY(Component.LEFT_ALIGNMENT);
	        labelMinStock.setBorder(border);
	        
	        labelMaxStock.setAlignmentX(Component.LEFT_ALIGNMENT);
	        labelMaxStock.setAlignmentY(Component.LEFT_ALIGNMENT);
	        labelMaxStock.setBorder(border);
	        panel1.add(labelProductName);
	        panel1.add(labelPurchasePrice);
	        panel1.add(labelSalePrice);
	        panel1.add(labelRentPrice);
	        panel1.add(labelCountryOrigin);
	        panel1.add(labelMinStock);
	        panel1.add(labelMaxStock);
	        panel1.updateUI();
	         
	        fieldProductName.setAlignmentX(Component.RIGHT_ALIGNMENT);
	        fieldProductName.setAlignmentY(Component.RIGHT_ALIGNMENT);
	        fieldPurchasePrice.setAlignmentX(Component.RIGHT_ALIGNMENT);
	        fieldPurchasePrice.setAlignmentY(Component.RIGHT_ALIGNMENT);
	        fieldSalePrice.setAlignmentX(Component.RIGHT_ALIGNMENT);
	        fieldSalePrice.setAlignmentY(Component.RIGHT_ALIGNMENT);
	        fieldRentPrice.setAlignmentX(Component.RIGHT_ALIGNMENT);
	        fieldRentPrice.setAlignmentY(Component.RIGHT_ALIGNMENT);
	        fieldCountryOrigin.setAlignmentX(Component.RIGHT_ALIGNMENT);
	        fieldCountryOrigin.setAlignmentY(Component.RIGHT_ALIGNMENT);
	        fieldMinStock.setAlignmentX(Component.RIGHT_ALIGNMENT);
	        fieldMinStock.setAlignmentY(Component.RIGHT_ALIGNMENT);
	        fieldMaxStock.setAlignmentX(Component.RIGHT_ALIGNMENT);
	        fieldMaxStock.setAlignmentY(Component.RIGHT_ALIGNMENT);
	        panel2.add(fieldProductName);
	        panel2.add(fieldPurchasePrice);
	        panel2.add(fieldSalePrice);
	        panel2.add(fieldRentPrice);
	        panel2.add(fieldCountryOrigin);
	        panel2.add(fieldMinStock);
	        panel2.add(fieldMaxStock);
	        panel2.updateUI();



			// Add the panels into the frame
			middlePanel.add(BorderLayout.WEST, panel1);
			middlePanel.add(BorderLayout.EAST, panel2);
			middlePanel.revalidate();
			frame.add(BorderLayout.CENTER, middlePanel);

			JButton confirm = new JButton("Confirm");
			confirm.setMaximumSize(new Dimension (100, 0));
			confirm.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					matchFieldsAndUpdates();
					try {
						productController.updateProduct(productToEdit.getProductID(), name, purchasePrice, salePrice, rentPrice, countryOrigin, minStock, maxStock);
						JOptionPane.showMessageDialog(null, "Product updated.");
					} catch (DataAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
			frame.add(BorderLayout.AFTER_LAST_LINE, confirm);


			frame.revalidate();
			frame.repaint();


			System.out.println("Edit Product Page opened");

		}
		
		public void matchFieldsAndUpdates() {
			if (fieldProductName != null) {
				name = fieldProductName.getText();
			}
			else {
				 name = productToEdit.getName();
			}
			
			if (fieldPurchasePrice != null) {
				purchasePrice = Double.parseDouble(fieldPurchasePrice.getText());
			}
			else {
				purchasePrice = productToEdit.getPurchasePrice();
			}
			
			if (fieldSalePrice != null) {
				salePrice = Double.parseDouble(fieldSalePrice.getText());
			}
			else {
				salePrice = productToEdit.getSalePrice();
			}
			
			if (fieldRentPrice != null) {
				rentPrice = Double.parseDouble(fieldRentPrice.getText());
			}
			else {
				rentPrice = productToEdit.getRentPrice();
			}
			
			if (fieldCountryOrigin != null) {
				countryOrigin = fieldSalePrice.getText();
			}
			else {
				countryOrigin = productToEdit.getCountryOfOrigin();
			}
			
			if (fieldMinStock != null) {
				minStock = Integer.parseInt(fieldMinStock.getText());
			}
			else {
				minStock = productToEdit.getMinStock();
			}
			
			if (fieldMaxStock != null) {
				maxStock = Integer.parseInt(fieldMaxStock.getText());
			}
			else {
				maxStock = productToEdit.getMaxStock();
			}
			
			
		}

	}
}
