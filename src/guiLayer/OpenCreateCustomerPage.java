package guiLayer;

import java.awt.BorderLayout;

import modelLayer.Customer;
import modelLayer.PrivateCustomer;
import controllerLayer.CustomerController;
import controllerLayer.DataAccessException;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import guiLayer.OpenCreateProductPage.CreateProductPage;


public class OpenCreateCustomerPage extends AbstractAction {
	JFrame frame;
	String text;
	CustomerController customerController;

	public OpenCreateCustomerPage(JFrame frame, String text){
		super(text);
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		new CreateCustomerPage(frame, text);
		try {
			customerController = new CustomerController();
		} catch (DataAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}




	public class CreateCustomerPage extends JFrame {

		JFrame frame;
		Container mainPanel;
		Container middlePanel;

		public CreateCustomerPage(JFrame frame, String texte){

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
			JLabel labelFirstName = new JLabel("First name");        
			JLabel labelLastName = new JLabel("Last name");
			JLabel labelPhoneNo = new JLabel("Phone No");
			JLabel labelContactInfo = new JLabel("Contact info");
			JTextField fieldFirstName = new JTextField("TestFirstName");        
			JTextField fieldLastName = new JTextField("TestLastName");
			JTextField fieldPhoneNo = new JTextField("12345");
			JTextField fieldContactInfo = new JTextField("No contact info");


			// Define the panel to hold the buttons 
			JPanel panel1 = new JPanel();
			JPanel panel2 = new JPanel();


			// Set up the BoxLayout
			BoxLayout layout1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
			BoxLayout layout2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
			panel1.setLayout(layout1);
			panel2.setLayout(layout2);

			// Add the buttons into the panel with three different alignment options
			EmptyBorder border = new EmptyBorder(2, 0, 2, 0);

			labelFirstName.setAlignmentX(Component.LEFT_ALIGNMENT);
			labelFirstName.setAlignmentY(Component.LEFT_ALIGNMENT);
			labelFirstName.setBorder(border);

			labelLastName.setAlignmentX(Component.LEFT_ALIGNMENT);
			labelLastName.setAlignmentY(Component.LEFT_ALIGNMENT);
			labelLastName.setBorder(border);

			labelPhoneNo.setAlignmentX(Component.LEFT_ALIGNMENT);
			labelPhoneNo.setAlignmentY(Component.LEFT_ALIGNMENT);
			labelPhoneNo.setBorder(border);

			labelContactInfo.setAlignmentX(Component.LEFT_ALIGNMENT);
			labelContactInfo.setAlignmentY(Component.LEFT_ALIGNMENT);
			labelContactInfo.setBorder(border);

			panel1.add(labelFirstName);
			panel1.add(labelLastName);
			panel1.add(labelPhoneNo);
			panel1.add(labelContactInfo);

			fieldFirstName.setAlignmentX(Component.LEFT_ALIGNMENT);
			fieldFirstName.setAlignmentY(Component.CENTER_ALIGNMENT);
			fieldLastName.setAlignmentX(Component.LEFT_ALIGNMENT);
			fieldLastName.setAlignmentY(Component.CENTER_ALIGNMENT);
			fieldPhoneNo.setAlignmentX(Component.LEFT_ALIGNMENT);
			fieldPhoneNo.setAlignmentY(Component.CENTER_ALIGNMENT);
			fieldContactInfo.setAlignmentX(Component.LEFT_ALIGNMENT);
			fieldContactInfo.setAlignmentY(Component.CENTER_ALIGNMENT);
			panel2.add(fieldFirstName);
			panel2.add(fieldLastName);
			panel2.add(fieldPhoneNo);
			panel2.add(fieldContactInfo);



			// Add the panels into the frame
			middlePanel.add(BorderLayout.WEST, panel1);
			middlePanel.add(BorderLayout.EAST, panel2);
			middlePanel.revalidate();
			frame.add(BorderLayout.CENTER, middlePanel);


			JButton confirm = new JButton("Confirm");
			confirm.setMaximumSize(new Dimension (100, 0));
			confirm.addMouseListener(new MouseAdapter() {
				@Override
				//Currently only a private customer can be added
				public void mouseClicked(MouseEvent e) {
					PrivateCustomer customerToAdd = new PrivateCustomer(fieldFirstName.getText(), fieldLastName.getText(), fieldPhoneNo.getText(), fieldContactInfo.getText());
					try {
						customerController.insertPrivateCustomer(customerToAdd);
						JOptionPane.showMessageDialog(null, "Customer created.");
					} catch (DataAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});

			frame.add(BorderLayout.AFTER_LAST_LINE, confirm);



			frame.revalidate();
			frame.repaint();


			System.out.println("Create Customer Page opened");

		}

	}
}
