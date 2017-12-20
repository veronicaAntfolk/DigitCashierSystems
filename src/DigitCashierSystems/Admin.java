package DigitCashierSystems;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Admin extends JPanel{
	
	private JTextField txtFieldCode;
	private JTextField txtFieldEmpFName;
	private JTextField txtFieldEmpLName;
	private JTextField txtFieldEmpBDate;
	private JTextField txtFieldEmpAddress;
	private JTextField txtFieldEmpPhone;
	private JTextField txtFieldEmpEmail;
	JLabel lblUserAdmin;
	private JPanel panelAdminEmployee;
	private JPanel panelAdminItem;
	
	private JList<Object> listEmployees;
	DefaultListModel<Object> dlm;
	
	DigitCashier dc = new DigitCashier();
	private Connection connect = null;
	



	public Admin() {
		initialize();
	}
	
	
	
	private void initialize() {

	JFrame frmAdmin = new JFrame();
	frmAdmin.setResizable(false);
	frmAdmin.setVisible(true);
	frmAdmin.setTitle("Digit Cashier");
	frmAdmin.setBounds(100, 100, 619, 651);
	frmAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frmAdmin.getContentPane().setLayout(new CardLayout(0,0));
	
	
	JPanel panelAdmin = new JPanel();
	frmAdmin.getContentPane().add(panelAdmin);
	panelAdmin.setLayout(null);
	
	JLabel lblUserA = new JLabel("User:");
	lblUserA.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblUserA.setBounds(12, 13, 44, 28);
	panelAdmin.add(lblUserA);
	
	lblUserAdmin = new JLabel("");
	lblUserAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblUserAdmin.setBounds(58, 13, 540, 28);
	panelAdmin.add(lblUserAdmin);
	
	JLabel lblTimeA = new JLabel("");
	lblTimeA.setBounds(290, 13, 204, 28);
	panelAdmin.add(lblTimeA);
	
	JButton btnEmployee = new JButton("Employee");
	btnEmployee.setFont(new Font("Tahoma", Font.PLAIN, 18));
	btnEmployee.setBounds(74, 185, 204, 77);
	panelAdmin.add(btnEmployee);
	btnEmployee.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			panelAdmin.setVisible(false);
			panelAdminEmployee.setVisible(true);
			//fillEmployeeList();
		}
	});
	
	JButton btnItem = new JButton("Item");
	btnItem.setFont(new Font("Tahoma", Font.PLAIN, 18));
	btnItem.setBounds(319, 185, 204, 77);
	panelAdmin.add(btnItem);
	btnItem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			panelAdmin.setVisible(false);
			panelAdminItem.setVisible(true);	
		}
	});
	
	JPanel panelAdminEmployee = new JPanel();
	frmAdmin.getContentPane().add(panelAdminEmployee);
	panelAdminEmployee.setLayout(null);
	
	
	JLabel lblUserA2 = new JLabel("User:");
	lblUserA2.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblUserA2.setBounds(12, 13, 44, 28);
	panelAdminEmployee.add(lblUserA2);
	
	JLabel lblUserAdmin2 = new JLabel("");
	lblUserAdmin2.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblUserAdmin2.setBounds(65, 13, 213, 28);
	panelAdminEmployee.add(lblUserAdmin2);
	
	JLabel labelTimeA2 = new JLabel("");
	labelTimeA2.setBounds(290, 13, 204, 28);
	panelAdminEmployee.add(labelTimeA2);
	
	JLabel lblEmployees = new JLabel("Employees:");
	lblEmployees.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblEmployees.setBounds(12, 115, 82, 16);
	panelAdminEmployee.add(lblEmployees);
	
	listEmployees = new JList();
	listEmployees.setBorder(new LineBorder(new Color(0, 0, 0)));
	listEmployees.setBounds(12, 145, 160, 423);
	panelAdminEmployee.add(listEmployees);
	
	JLabel lblCode = new JLabel("ID Code:");
	lblCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblCode.setAutoscrolls(true);
	lblCode.setBounds(191, 68, 82, 28);
	panelAdminEmployee.add(lblCode);
	
	txtFieldCode = new JTextField();
	txtFieldCode.setColumns(10);
	txtFieldCode.setBorder(new LineBorder(new Color(0, 0, 0)));
	txtFieldCode.setBounds(290, 69, 112, 28);
	panelAdminEmployee.add(txtFieldCode);
	
	JLabel lblEmpFName = new JLabel("Firstname: ");
	lblEmpFName.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblEmpFName.setAutoscrolls(true);
	lblEmpFName.setBounds(191, 109, 82, 28);
	panelAdminEmployee.add(lblEmpFName);
	
	txtFieldEmpFName = new JTextField();
	txtFieldEmpFName.setBorder(new LineBorder(new Color(0, 0, 0)));
	txtFieldEmpFName.setBounds(290, 110, 283, 28);
	panelAdminEmployee.add(txtFieldEmpFName);
	txtFieldEmpFName.setColumns(10);
	
	JLabel lblEmpLName = new JLabel("Lastname: ");
	lblEmpLName.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblEmpLName.setAutoscrolls(true);
	lblEmpLName.setBounds(191, 150, 82, 28);
	panelAdminEmployee.add(lblEmpLName);
	
	txtFieldEmpLName = new JTextField();
	txtFieldEmpLName.setBorder(new LineBorder(new Color(0, 0, 0)));
	txtFieldEmpLName.setColumns(10);
	txtFieldEmpLName.setBounds(290, 151, 283, 28);
	panelAdminEmployee.add(txtFieldEmpLName);
	
	JLabel lblEmpBDate = new JLabel("Birthdate:");
	lblEmpBDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblEmpBDate.setBounds(191, 191, 82, 28);
	panelAdminEmployee.add(lblEmpBDate);
	
	txtFieldEmpBDate = new JTextField();
	txtFieldEmpBDate.setBorder(new LineBorder(new Color(0, 0, 0)));
	txtFieldEmpBDate.setColumns(10);
	txtFieldEmpBDate.setBounds(290, 192, 283, 28);
	panelAdminEmployee.add(txtFieldEmpBDate);
	
	JLabel lblEmpAddress = new JLabel("Address:");
	lblEmpAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblEmpAddress.setBounds(191, 232, 82, 28);
	panelAdminEmployee.add(lblEmpAddress);
	
	txtFieldEmpAddress = new JTextField();
	txtFieldEmpAddress.setBorder(new LineBorder(new Color(0, 0, 0)));
	txtFieldEmpAddress.setColumns(10);
	txtFieldEmpAddress.setBounds(290, 233, 283, 28);
	panelAdminEmployee.add(txtFieldEmpAddress);
	
	JLabel lblEmpPhone = new JLabel("Phone");
	lblEmpPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblEmpPhone.setBounds(191, 273, 82, 28);
	panelAdminEmployee.add(lblEmpPhone);
	
	txtFieldEmpPhone = new JTextField();
	txtFieldEmpPhone.setBorder(new LineBorder(new Color(0, 0, 0)));
	txtFieldEmpPhone.setColumns(10);
	txtFieldEmpPhone.setBounds(290, 274, 283, 28);
	panelAdminEmployee.add(txtFieldEmpPhone);
	
	JLabel lblEmpEmail = new JLabel("Email:");
	lblEmpEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblEmpEmail.setBounds(191, 314, 82, 28);
	panelAdminEmployee.add(lblEmpEmail);
	
	txtFieldEmpEmail = new JTextField();
	txtFieldEmpEmail.setBorder(new LineBorder(new Color(0, 0, 0)));
	txtFieldEmpEmail.setColumns(10);
	txtFieldEmpEmail.setBounds(290, 315, 283, 28);
	panelAdminEmployee.add(txtFieldEmpEmail);
	
	JButton btnNewEmployee = new JButton("New Employee");
	btnNewEmployee.setBorder(new LineBorder(new Color(0, 0, 0)));
	btnNewEmployee.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnNewEmployee.setBounds(12, 54, 133, 48);
	panelAdminEmployee.add(btnNewEmployee);
	
	JButton btnSaveEmployee = new JButton("Save Employee");
	btnSaveEmployee.setBorder(new LineBorder(new Color(0, 0, 0)));
	btnSaveEmployee.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnSaveEmployee.setBounds(233, 372, 164, 48);
	panelAdminEmployee.add(btnSaveEmployee);
	btnSaveEmployee.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			saveEmployee();
			
		}
	});
	
	

	JButton btnDeleteEmployee = new JButton("Delete Employee");
	btnDeleteEmployee.setBorder(new LineBorder(new Color(0, 0, 0)));
	btnDeleteEmployee.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnDeleteEmployee.setBounds(409, 372, 164, 48);
	panelAdminEmployee.add(btnDeleteEmployee);
	
	JButton btnCancelAdmin = new JButton("Cancel");
	btnCancelAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnCancelAdmin.setBorder(new LineBorder(new Color(0, 0, 0)));
	btnCancelAdmin.setBounds(233, 426, 164, 48);
	panelAdminEmployee.add(btnCancelAdmin);
	
	JButton btnViewWorkingHours = new JButton("View working hours");
	btnViewWorkingHours.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnViewWorkingHours.setBorder(new LineBorder(new Color(0, 0, 0)));
	btnViewWorkingHours.setBounds(409, 426, 164, 48);
	panelAdminEmployee.add(btnViewWorkingHours);
	
	panelAdminItem = new JPanel();
	frmAdmin.getContentPane().add(panelAdminItem, "name_691474098256635");
	panelAdminItem.setLayout(null);
	
	JButton btnNewItem = new JButton("New Item");
	btnNewItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnNewItem.setBorder(new LineBorder(new Color(0, 0, 0)));
	btnNewItem.setBounds(12, 54, 133, 48);
	panelAdminItem.add(btnNewItem);
	
	JList listItems = new JList();
	listItems.setBorder(new LineBorder(new Color(0, 0, 0)));
	listItems.setBounds(12, 145, 160, 423);
	panelAdminItem.add(listItems);
	
	JLabel lblItems = new JLabel("Items:");
	lblItems.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblItems.setBounds(12, 115, 63, 19);
	panelAdminItem.add(lblItems);
	panelAdmin.setVisible(false);
	}
	
	
	
	
	public void saveEmployee() {
		String c = txtFieldCode.getText();
		int intC = Integer.parseInt(c);
		String fn = txtFieldEmpFName.getText();
		String ln = txtFieldEmpLName.getText();
		String bd = txtFieldEmpBDate.getText();
		String a = txtFieldEmpAddress.getText();
		String p = txtFieldEmpPhone.getText();
		String e = txtFieldEmpEmail.getText();
		
		try { 
		connect = dc.getConnection();
		String query = "INSERT INTO employees VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, intC);
		ps.setString(2, fn);
		ps.setString(3, ln);
		ps.setString(4, bd);
		ps.setString(5, a);
		ps.setString(6, p);
		ps.setString(7, e);
		ps.executeUpdate();
		
		
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}

	}
	
	public void fillEmployeeList() {
		
		try {
		
		ArrayList<Employees> employeeList = dc.getEmployeesList();
		
		for (Employees emp : employeeList) {
			if(emp.getIdCode()!= 0) {
			dlm.addElement(emp.getFName() + " " + emp.getLName());
			listEmployees.setModel(dlm);
			}
		}
		
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}

