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

import controllerLayer.CustomerController;
import controllerLayer.DataAccessException;

public class OpenDeleteCustomerPage extends AbstractAction {
	JFrame frame;
	String text;
	CustomerController customerController;

	public OpenDeleteCustomerPage(JFrame frame, String text){
		super(text);
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			customerController = new CustomerController();
		} catch (DataAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		new DeleteCustomerPage(frame, text);
	}
	
	
public class DeleteCustomerPage extends JFrame {
	JFrame frame;
	Container mainPanel;
	Container middlePanel;
	
	public DeleteCustomerPage(JFrame frame, String texte){
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
        JLabel labelCustomerName = new JLabel("Name of the customer to delete:");        
        JTextField fieldCustomerName = new JTextField("TestCustomer");        


         
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
        labelCustomerName.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel1.add(labelCustomerName);
        panel1.updateUI();
         
        fieldCustomerName.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panel2.add(fieldCustomerName);
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
				try {
					if (customerController.deletePrivateCustomer(customerController.findByCustomerName(fieldCustomerName.getText(), false)) != null) {
					JOptionPane.showMessageDialog(null, "Customer deleted.");
					}
					else {
						JOptionPane.showMessageDialog(null, "An error happened. Please contact the developers.");
					}
				} catch (DataAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		frame.add(BorderLayout.AFTER_LAST_LINE, confirm);
		
        frame.revalidate();
        frame.repaint();

		
        System.out.println("Delete Customer Page opened");
		
		}
	}
}
