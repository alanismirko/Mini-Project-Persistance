package guiLayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controllerLayer.DataAccessException;
import controllerLayer.ProductController;
import modelLayer.Product;

public class OpenCreateProductPage extends AbstractAction {
	JFrame frame;
	String text;
	ProductController productController;

	public OpenCreateProductPage(JFrame frame, String text){
		super(text);
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			productController = new ProductController();
		} catch (DataAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		new CreateProductPage(frame, text);
	}
	
	
public class CreateProductPage extends JFrame {
	JFrame frame;
	Container mainPanel;
	Container middlePanel;
	
	public CreateProductPage(JFrame frame, String texte){
		super(texte);
		this.frame = frame;
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
		JLabel labelProductID = new JLabel("ID");
        JLabel labelProductName = new JLabel("Name");        
        JLabel labelPurchasePrice = new JLabel("Purchase price");
        JLabel labelSalePrice = new JLabel("Sale price");
        JLabel labelRentPrice = new JLabel("Rent price");
        JLabel labelCountryOrigin = new JLabel("Country of origin");
        JLabel labelMinStock = new JLabel("Min. stock");
        JLabel labelMaxStock = new JLabel("Max. stock");
        JTextField fieldProductID = new JTextField("");
        JTextField fieldProductName = new JTextField("TestProductName");        
        JTextField fieldPurchasePrice = new JTextField("10");
        JTextField fieldSalePrice = new JTextField("20");
        JTextField fieldRentPrice = new JTextField("15");
        JTextField fieldCountryOrigin = new JTextField("Neverland");
        JTextField fieldMinStock = new JTextField("1");
        JTextField fieldMaxStock = new JTextField("100");

         
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
         
        // Add the buttons into the panel with borders and two different alignment options
        EmptyBorder border = new EmptyBorder(2, 0, 2, 0);
        
        labelProductID.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelProductID.setAlignmentY(Component.LEFT_ALIGNMENT);
        labelProductID.setBorder(border);
        
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
        
        panel1.add(labelProductID);
        panel1.add(labelProductName);
        panel1.add(labelPurchasePrice);
        panel1.add(labelSalePrice);
        panel1.add(labelRentPrice);
        panel1.add(labelCountryOrigin);
        panel1.add(labelMinStock);
        panel1.add(labelMaxStock);
        panel1.updateUI();
         
        fieldProductID.setAlignmentX(Component.RIGHT_ALIGNMENT);
        fieldProductID.setAlignmentY(Component.RIGHT_ALIGNMENT);
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
        panel2.add(fieldProductID);
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
        frame.add(BorderLayout.CENTER, middlePanel);
		

		JButton confirm = new JButton("Confirm");
		confirm.setMaximumSize(new Dimension (100, 0));
		confirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Product productToAdd = new Product(Integer.parseInt(fieldProductID.getText()), fieldProductName.getText(),  Double.parseDouble(fieldPurchasePrice.getText()), Double.parseDouble(fieldSalePrice.getText()), Double.parseDouble(fieldRentPrice.getText()),
						fieldCountryOrigin.getText(), Integer.parseInt(fieldMinStock.getText()), Integer.parseInt(fieldMaxStock.getText()));
				try {
					productController.insertProduct(productToAdd);
					JOptionPane.showMessageDialog(null, "Product created.");
				} catch (DataAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		frame.add(BorderLayout.AFTER_LAST_LINE, confirm);

		
        frame.revalidate();
        frame.repaint();

		
        System.out.println("Create Product Page opened");
		
	}

}
}
