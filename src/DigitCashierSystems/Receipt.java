package DigitCashierSystems;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JTextArea;



public class Receipt {

	public static void writeReceipt(ArrayList<Items> o, Double totPrice, Double pay, Double chan, String n, int oNr) {
		String companyName = "Cash Digi";
		String companyAddress = "Järnvågsgatan 3";
		String companyZip = "413 27 Göteborg";
		String companyPhone = "031-523645";
		Double tax = 12.00;
		Double dTax = tax/100;
		Double taxAmount = totPrice * dTax;
		Double netto = totPrice - taxAmount;
		File out = new File("orderFile.txt");
		String sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		
		
		try {
			
			FileWriter fw = new FileWriter( out);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("\t" + companyName);
			pw.println();
			pw.println("\t" + companyAddress);
			pw.println("\t" + companyZip);
			pw.println("\t" + companyPhone);
			//pw.println();
			pw.println("------------------------------------------------------");
			//pw.println();
			for (int i = 0; i<o.size(); i++) {
				pw.println(o.get(i).getItemNumber() + "\t" + o.get(i).getItemName() 
						+ "\t" + String.format("%.2f" , o.get(i).getPrice()));
			}
			//pw.println();
			pw.println("------------------------------------------------------");
			//pw.println();
			//pw.println(o.size() + " items");
			pw.println("Total cost: \t\t" + String.format("%.2f" , totPrice) + "kr");
			pw.println("Payed: \t\t" + String.format("%.2f" , pay));
			pw.println("Change: \t\t" + String.format("%.2f" , chan));
			pw.println();
			pw.println("Tax         Tax         Netto        Brutto");
			pw.println(String.format("%.2f" , tax) + "      " + String.format("%.2f" , taxAmount)
				+ "      " + String.format("%.2f" , netto) + "      " + String.format("%.2f" , totPrice));
			pw.println("------------------------------------------------------");
			pw.println("Receipt number: " + oNr);
			pw.println(sdf);
			pw.println("Assisted by: " + n);
			
			
			pw.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public static void printReceipt() {
		
		try {
			
			JFrame receiptFrame = new JFrame();
			receiptFrame.setSize(300, 500);
			receiptFrame.setLocation(20,20);
			receiptFrame.setVisible(true);
			receiptFrame.setResizable(false);
			JTextArea receiptArea = new JTextArea();
			receiptArea.setEditable(false);
			receiptArea.setSize(250, 450);
			receiptArea.setLocation(40, 40);
			receiptFrame.getContentPane().add(receiptArea, BorderLayout.CENTER);
			
			BufferedReader in = new BufferedReader(new FileReader("orderFile.txt"));
			String s;
			while ((s = in.readLine()) != null) {
				receiptArea.append(s + "\n");
			}
			
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
