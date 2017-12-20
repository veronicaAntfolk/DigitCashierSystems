package DigitCashierSystems;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Items {

	private String itemNumber;
	private String itemName;
	private double price;
	private int quantity;
	private String category;
	private double weight;
	private String supplier;
	
	//Constructor that empties values in variables
	public Items() {
		this.itemNumber = "";
		this.itemName = "";
		this.price = 0;
		this.quantity = 0;
		this.category = "";
		this.weight = 0;
		this.supplier = "";
	}
	
	//Constructor that connects variables to parameter values
	public Items(String nr, String name, double pr, int quant, String cat, double weig, String sup) {
		this.itemNumber = nr;
		this.itemName = name;
		this.price = pr;
		this.quantity = quant;
		this.category = cat;
		this.weight = weig;
		this.supplier = sup;
	}
	
	//Setting values to itemNumber, itemName, price, quantity, category, weight and supplier
	public void setItemNumber(String nr) {
		itemNumber = nr;
	}
	
	public void setItemName(String name) {
		itemName = name;
	}
	
	public void setPrice(double pr) {
		price = pr;
	}
	
	public void setQuantity(int quant) {
		quantity = quant;
	}
	
	public void setCategory(String cat) {
		category = cat;
	}
	
	public void setWeight(double weigh) {
		if (category.equals("Vegetable")) {
			weight = weigh;
		}
		else if (category.equals("Fruit")) {
			weight = weigh;
		}
		else {
			weight = 0;
		}
	}
	
	public void setSupplier(String sup) {
		supplier = sup;
	}
	
	//Getting values from itemNumber, itemName, price, quantity, category, weight and supplier
	public String getItemNumber() {
		return itemNumber;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String getCategory() {
		return category;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public String getSupplier() {
		return supplier;
	}
	
	
}