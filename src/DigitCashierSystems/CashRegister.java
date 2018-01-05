package DigitCashierSystems;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;





public class CashRegister extends JPanel {

	private JFrame frmCashRegister;
	private JPanel pnlCashRegister;
	private JTextField txtField;
	private JLabel lblTotSum;
	private JLabel lblPayed;
	private JLabel lblChange;
	JLabel lblUserCashier;
	
	DigitCashier dc = new DigitCashier();
	Receipt r = new Receipt();
	private Connection connect = null;
	private int code;
	public Double payment;
	public double change;
	public int orderNr = 100;
	public Double totSum = 0.00;
	JList<Object> listShoppingCart;
	DefaultListModel<Object> dlm;
	ArrayList<Items> order = new ArrayList<Items>();
	
	public CashRegister() {
		
		initialize();
	}
	

	private void initialize() {
		frmCashRegister = new JFrame();
		frmCashRegister.setResizable(false);
		frmCashRegister.setVisible(true);
		frmCashRegister.setTitle("Digit Cashier");
		frmCashRegister.setBounds(100, 100, 619, 651);
		frmCashRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCashRegister.getContentPane().setLayout(new CardLayout(0,0));
		
		pnlCashRegister = new JPanel();
		pnlCashRegister.setBackground(SystemColor.window);
		pnlCashRegister.setLayout(null);
		pnlCashRegister.setVisible(true);
		frmCashRegister.getContentPane().add(pnlCashRegister);
		
		txtField = new JTextField();
		txtField.setEditable(false);
		txtField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtField.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtField.setBackground(new Color(255, 255, 255));
		txtField.setBounds(11, 54, 257, 57);
		pnlCashRegister.add(txtField);
		txtField.setColumns(10);
		
		//Create buttons and setting text in textfield to number on button
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn1.setBounds(12, 114, 84, 40);
		pnlCashRegister.add(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String enteredNr = txtField.getText() + btn1.getText();
				txtField.setText(enteredNr);
			}
		});
						
		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn2.setBounds(98, 114, 84, 40);
		pnlCashRegister.add(btn2);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enteredNr = txtField.getText() + btn2.getText();
				txtField.setText(enteredNr);
			}
		});
						
		JButton btn3 = new JButton("3");
		btn3.setBounds(184, 114, 84, 40);
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnlCashRegister.add(btn3);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enteredNr = txtField.getText() + btn3.getText();
				txtField.setText(enteredNr);
			}
		});
					
		JButton btn4 = new JButton("4");
		btn4.setBounds(12, 156, 84, 40);
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnlCashRegister.add(btn4);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enteredNr = txtField.getText() + btn4.getText();
				txtField.setText(enteredNr);
			}
		});
						
		JButton btn5 = new JButton("5");
		btn5.setBounds(98, 156, 84, 40);
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnlCashRegister.add(btn5);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enteredNr = txtField.getText() + btn5.getText();
				txtField.setText(enteredNr);
			}
		});
						
		JButton btn6 = new JButton("6");
		btn6.setBounds(184, 156, 84, 40);
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnlCashRegister.add(btn6);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enteredNr = txtField.getText() + btn6.getText();
				txtField.setText(enteredNr);
			}
		});
			
		JButton btn7 = new JButton("7");
		btn7.setBounds(12, 199, 84, 40);
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnlCashRegister.add(btn7);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enteredNr = txtField.getText() + btn7.getText();
				txtField.setText(enteredNr);
			}
		});
			
		JButton btn8 = new JButton("8");
		btn8.setBounds(98, 199, 84, 40);
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnlCashRegister.add(btn8);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enteredNr = txtField.getText() + btn8.getText();
				txtField.setText(enteredNr);
			}
		});
					
		JButton btn9 = new JButton("9");
		btn9.setBounds(184, 199, 84, 40);
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnlCashRegister.add(btn9);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enteredNr = txtField.getText() + btn9.getText();
				txtField.setText(enteredNr);
			}
		});
		
		JButton btn0 = new JButton("0");
		btn0.setBounds(98, 242, 84, 40);
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnlCashRegister.add(btn0);
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enteredNr = txtField.getText() + btn0.getText();
				txtField.setText(enteredNr);
			}
		});
		
		//Creates dot button that puts a dot in the textField so we can input price and weight
		JButton btnDot = new JButton(".");
		btnDot.setBounds(98, 285, 84, 40);
		btnDot.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnlCashRegister.add(btnDot);
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String enteredNr = txtField.getText() + btnDot.getText();
				txtField.setText(enteredNr);
			}
		});
		
		//Creating add button and adding text in textfield to textarea. Removes text from textfield
		JButton btnAdd = new JButton("+");
		btnAdd.setBounds(12, 242, 84, 40);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnlCashRegister.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					String itemNr = txtField.getText();
					ArrayList<Items> itemList = getItemsList();
							
					for (Items i : itemList) {
						if (i.getItemNumber() != null && i.getItemNumber().equals(itemNr)) {
							order.add(i);
							dlm.addElement(i.getItemNumber() + "  " + i.getItemName() + "  " + String.format("%.2f" , i.getPrice() ) );
							listShoppingCart.setModel(dlm);
									
						}
					}
							
					totSum = getTotalPrice(order);
					txtField.setText("");	
									
				}catch(Exception d) {
						d.printStackTrace();
				}
						
			}
		});
		
		
		//Makes a button that empties textField
		JButton btnMinus = new JButton("-");
		btnMinus.setBounds(184, 242, 84, 40);
		btnMinus.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnlCashRegister.add(btnMinus);
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtField.setText("");
			}
		});
		
		//Creates coupon button and makes a discount of the total sum
		JButton btnCoupon = new JButton("Coupon");
		btnCoupon.setBackground(new Color(0, 153, 102));
		btnCoupon.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnCoupon.setBounds(11, 339, 257, 40);
		pnlCashRegister.add(btnCoupon);
		btnCoupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int coupon = Integer.parseInt(txtField.getText());
				if (coupon>0 && coupon<100) {
					int discount = 100 - coupon;
					Double dis = 1.0 * discount;
					dis = dis/100;
					getTotalPrice(order);
					totSum = totSum * dis;
					lblTotSum.setText("Total sum: " + totSum + " kr");
					txtField.setText("");
						
				}
				
			}
		});
				
		//Creates done button to be pressed when customer has payed to write out receipt and wipe everything clean
		JButton btnDone = new JButton("Done");
		btnDone.setForeground(Color.BLACK);
		btnDone.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnDone.setBackground(new Color(255, 255, 0));
		btnDone.setBounds(11, 499, 122, 40);
		pnlCashRegister.add(btnDone);
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eName = lblUserCashier.getText();
				String[] eN = eName.split("\\.");
				eName = eN[0];
				totSum = getTotalPrice(order);
				Receipt.writeReceipt(order, totSum, payment, change, eName, orderNr);
				Receipt.printReceipt();
				orderNr++;
				clearScreen();
				
				
					
					
						
			}
		});
				
		//Create logout button and goes back to login page 
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogout.setBackground(UIManager.getColor("Button.background"));
		btnLogout.setBounds(11, 565, 111, 40);
		pnlCashRegister.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DigitCashier dc = new DigitCashier();
				frmCashRegister.setVisible(false);
				dc.frmLogin.setVisible(true);
			}
		});
		
	
		//Create a button for customer paying with card
		JButton btnCard = new JButton("Card");
		btnCard.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCard.setBackground(new Color(144, 238, 144));
		btnCard.setBounds(146, 393, 122, 40);
		pnlCashRegister.add(btnCard);
		btnCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPayed.setText("Payed: " + String.format("%.2f" , totSum) + "kr");
				lblChange.setText("Change: 0.00 kr");
				
			}
		});
		
		
		//Create a button for customer paying with cash
		JButton btnCash = new JButton("Cash");
		btnCash.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnCash.setBackground(new Color(0, 153, 204));
		btnCash.setBounds(11, 393, 122, 40);
		pnlCashRegister.add(btnCash);
		btnCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String pmnt = txtField.getText();
				payment = Double.parseDouble(pmnt);
				int paymentInt = (int) Math.round(payment);
				int totSumInt = (int) Math.round(totSum);
				change = paymentInt - totSumInt;
				payment = (double)paymentInt;
				totSum = (double)totSumInt;
				txtField.setText("");
				lblPayed.setText("Payed: " +  String.format("%.2f" , payment) + "kr");
				lblChange.setText("Change: " + String.format("%.2f" , change) + "kr");
			}
		});
				
				
		//Create remove button and removes selected item from listShoppingCart
		JButton btnRemoveItem = new JButton("Delete");
		btnRemoveItem.setForeground(Color.BLACK);
		btnRemoveItem.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnRemoveItem.setBackground(new Color(255, 0, 0));
		btnRemoveItem.setBounds(11, 446, 257, 40);
		pnlCashRegister.add(btnRemoveItem);
		btnRemoveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = listShoppingCart.getSelectedIndex();
				if (index != -1) {
					dlm.remove(index);
					order.remove(index);
					totSum = getTotalPrice(order);
							
				}
			}
		});
				
				
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnCancel.setBackground(new Color(255, 51, 0));
		btnCancel.setBounds(146, 499, 122, 40);
		pnlCashRegister.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearScreen();
			}
		});
				
				
		//Creates a button that can recalculate price depending on the weight
		JButton btnWeight = new JButton("Weight");
		btnWeight.setBounds(12, 286, 84, 40);
		btnWeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlCashRegister.add(btnWeight);
		btnWeight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = listShoppingCart.getSelectedIndex();
				String w = txtField.getText();
				Double dw = Double.parseDouble(w);
				String cat = order.get(index).getCategory();
				
				if (cat.equals("Vegetable") || cat.equals("Fruit")) {
				Double op = order.get(index).getPrice();
				Double newPrice = dw * op;
				order.get(index).setPrice(newPrice);
				order.get(index).setWeight(dw);
				txtField.setText("");
				totSum = getTotalPrice(order);
				dlm.removeElementAt(index);
				dlm.addElement(order.get(index).getItemNumber() + " " + order.get(index).getItemName() + " " + order.get(index).getPrice());
				}
				else {
					txtField.setText("Not a fruit or vegetable");
				}
			}
		});
		
	
		//Creates a button that recalculates price depending on amount
		JButton btnAmount = new JButton("Amount");
		btnAmount.setBounds(184, 285, 84, 40);
		btnAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlCashRegister.add(btnAmount);
		btnAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = listShoppingCart.getSelectedIndex();
				String a = txtField.getText();
				int ia = Integer.parseInt(a);
				String cat = order.get(index).getCategory();
					
				if (!(cat.equals("Fruit")) && !(cat.equals("Vegetable"))) {
					Double op = order.get(index).getPrice();
					Double newPrice = op * ia;
					order.get(index).setPrice(newPrice);
					order.get(index).setQuantity(ia);
					txtField.setText("");
					totSum = getTotalPrice(order);
					dlm.removeElementAt(index);
					dlm.addElement(order.get(index).getItemNumber() + " " + order.get(index).getItemName() + " " + order.get(index).getPrice());
				}
				else {
					txtField.setText("A fruit or vegetable");
				}
				
			}
		});

		
		
		listShoppingCart = new JList<Object>();
		listShoppingCart.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listShoppingCart.setBorder(new LineBorder(new Color(0, 0, 0)));
		listShoppingCart.setBounds(285, 54, 321, 228);
		dlm = new DefaultListModel<Object>();
		pnlCashRegister.add(listShoppingCart);
		
		lblTotSum = new JLabel("Total sum: ");
		lblTotSum.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblTotSum.setBounds(308, 353, 272, 31);
		pnlCashRegister.add(lblTotSum);
		
		lblPayed = new JLabel("Payed:");
		lblPayed.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblPayed.setBounds(308, 393, 272, 31);
		pnlCashRegister.add(lblPayed);
		
		lblChange = new JLabel("Change:");
		lblChange.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblChange.setBounds(311, 435, 272, 31);
		pnlCashRegister.add(lblChange);
		
		JLabel lblUserC = new JLabel("User:");
		lblUserC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUserC.setBounds(12, 13, 44, 28);
		pnlCashRegister.add(lblUserC);
		
		lblUserCashier = new JLabel("");
		lblUserCashier.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUserCashier.setBounds(58, 13, 540, 28);
		pnlCashRegister.add(lblUserCashier);
		
					
	}
	
	
	//This method puts data from DB table items into a arraylist called itemsList
	public ArrayList<Items> getItemsList(){
		connect = dc.getConnection();
		ArrayList<Items> itemsList = new ArrayList<Items>();
			
		String query = "SELECT * FROM items ";
		Statement st;
		ResultSet rs;
				
		try {
			st = connect.createStatement();
			rs = st.executeQuery(query);
			Items item;
			
			while(rs.next()) {
				item = new Items(rs.getString("item_id"), rs.getString("item_name"), rs.getDouble("price"),
						rs.getInt("quantity"), rs.getString("category"), rs.getDouble("weight"),
						rs.getString("supplier"));
				itemsList.add(item);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return itemsList;
	}
			

	//This method calculates the total sum of all items in shopping cart
	public Double getTotalPrice(ArrayList<Items> o ) {
		ArrayList<Double> ts = new ArrayList<Double>();
		for (Items i : o) {
			ts.add(i.getPrice());
		}
		
		Double a = 0.00;
		for (Double d : ts) {
			a += d;
		}
		
		lblTotSum.setText("Total sum: " + String.format("%.2f" , a) + " kr");
		return a;
	}
	
	public void clearScreen() {
		order.clear();
		lblTotSum.setText("Total Sum: ");
		lblPayed.setText("Payed: ");
		lblChange.setText("Change: ");
		listShoppingCart.removeAll();
		dlm.removeAllElements();
	}
	
	
	
	
}


