package DigitCashierSystems;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;




public class DigitCashier {

	private Connection connect = null;
	final private String url = "jdbc:mysql://localhost:3306/digit_cashier?useSSL=false";
	final private String sqluser =  "KarinLinaVeronica";
	final private String sqlpasswd = "HumanuS2017";
	private Statement statement = null;
	private PreparedStatement ps  = null;
	private ResultSet rs = null;
	
	JFrame frmLogin;
	private JPanel pnlLogin;
	private JPasswordField passField;
	private JTextField txtFieldBDate;
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitCashier window = new DigitCashier();
					window.frmLogin.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		

	}
	
	/**
	 * Create the application.
	 */
	public DigitCashier() {
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setTitle("Digit Cashier");
		frmLogin.setBounds(100, 100, 619, 651);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(new CardLayout(0,0));
		
		pnlLogin = new JPanel();
		pnlLogin.setLayout(null);
		pnlLogin.setVisible(true);
		frmLogin.getContentPane().add(pnlLogin);
		
		JLabel lblLogin = new JLabel("Enter your birthdate and PIN to sign in.");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogin.setBounds(102, 183, 365, 25);
		pnlLogin.add(lblLogin);
		
		JLabel lblKod = new JLabel("PIN:");
		lblKod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKod.setBounds(235, 269, 56, 16);
		pnlLogin.add(lblKod);
		
		JLabel lblBirthdate = new JLabel("Birthdate:");
		lblBirthdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBirthdate.setBounds(201, 228, 70, 16);
		pnlLogin.add(lblBirthdate);
		
		txtFieldBDate = new JTextField();
		txtFieldBDate.setToolTipText("Birthdate format is YYYYMMDD-XXXX");
		txtFieldBDate.setBounds(274, 220, 133, 34);
		pnlLogin.add(txtFieldBDate);
		txtFieldBDate.setColumns(10);
		
		passField = new JPasswordField();
		passField.setToolTipText("3 digit PIN");
		passField.setBounds(274, 262, 133, 32);
		pnlLogin.add(passField);
		
		//Creates a login button and gets value from passwordField and textfieldBDate to compare with employeesList
				JButton btnLogin = new JButton("Login");
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							char[] pin = passField.getPassword();
							String p = new String(pin);
							int code = Integer.parseInt(p);
							String bDate = txtFieldBDate.getText();
							ArrayList<Employees> employeeList = getEmployeesList();
							
							//Search for user in employeeList
							for (Employees emp : employeeList) {
								if ((emp.getIdCode() == code) && (emp.getBirthDate().equals(bDate))) {
									
									//Check if code is between 200-299 and then make panelCashRegister visible
									if ((code >=200) && (code <=299)) {
										
										EventQueue.invokeLater(new Runnable() {
											public void run() {
												try {
													CashRegister cashReg = new CashRegister();
													frmLogin.getContentPane().add(cashReg);
													pnlLogin.setVisible(false);
													frmLogin.setVisible(false);
													cashReg.setVisible(true);
													String sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
													cashReg.lblUserCashier.setText(emp.getFName() + " " + emp.getLName() + ". Signed in: " + sdf);
												}catch(Exception e) {
													e.printStackTrace();
												}
											}
										});										
									}
									
									//Check if code is between 300-399 and then make panelCashRegister visible
									if ((code >=300) && (code <=399)) {
										
										EventQueue.invokeLater(new Runnable() {
											public void run() {
												try {
													Admin am = new Admin();
													frmLogin.getContentPane().add(am);
													pnlLogin.setVisible(false);
													frmLogin.setVisible(false);
													am.setVisible(true);
													String sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
													am.lblUserAdmin.setText(emp.getFName() + " " + emp.getLName() + ". Signed in: " + sdf);
												}catch(Exception e) {
													e.printStackTrace();
												}
											}
										});										
									}
									
									
									
									
								}
								
							}
							
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "Invalid Birthdate or PIN ");
							ex.printStackTrace();
						}
					}
				});
				btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
				btnLogin.setBackground(UIManager.getColor("Button.background"));
				btnLogin.setBounds(242, 323, 111, 40);
				pnlLogin.add(btnLogin);
		
		
	}
	
	

	//This method sets a connection to the DB digit_cashier
	public Connection getConnection() {
		try {
			//This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Setup the connection with the DB
			connect = DriverManager.getConnection(url, sqluser, sqlpasswd);
			return connect;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	//This method puts data from DB table employees into a arraylist called employeesList
		public ArrayList<Employees> getEmployeesList(){
			connect = getConnection();
			ArrayList<Employees> employeesList = new ArrayList<Employees>();
			String query = "SELECT * FROM employees ";
			Statement st;
			ResultSet rs;
			
			try {
				st = connect.createStatement();
				rs = st.executeQuery(query);
				Employees employee;
				
				while(rs.next()) {
					employee = new Employees(rs.getInt("employee_id"), rs.getString("employee_fname"), rs.getString("employee_lname"),
							rs.getString("birth_date"), rs.getString("address"), rs.getString("phone"),
							rs.getString("email"));
					employeesList.add(employee);
				}

			}catch (Exception e) {
				e.printStackTrace();
			}
			return employeesList;
		}
		
		//This method puts data from DB table items into a arraylist called itemsList
		public ArrayList<Items> getItemsList(){
			connect = getConnection();
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

}
