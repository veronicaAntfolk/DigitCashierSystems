package DigitCashierSystems;

public class Employees {

	private int idCode;
	private String fName;
	private String lName;
	private String birthDate;
	private String address;
	private String phone;
	private String email;
	
	//Constructor that empties values in variables
	public Employees() {
		this.idCode = 0;
		this.fName = "";
		this.lName = "";
		this.birthDate = "";
		this.address = "";
		this.phone = "";
		this.email = "";	
	}
	
	//Constructor that connects variables to parameter values
	public Employees(int id, String fN, String lN, String bD, String a, String p, String e) {
		this.idCode = id;
		this.fName = fN;
		this.lName = lN;
		this.birthDate = bD;
		this.address = a;
		this.phone = p;
		this.email = e;
	}
	
	//Setting values to idCode, fName, lName, birthDate, address, phone and email
	public void setIdCode(int id) {
		idCode = id;
	}
	
	public void setFName(String fN) {
		fName = fN;
	}
	
	public void setLName(String lN) {
		lName = lN;
	}
	
	public void setBirthDate(String bD) {
		birthDate = bD;
	}
	
	public void setAddress(String a) {
		address = a;
	}
	
	public void setPhone(String p) {
		phone = p;
	}
	
	public void setEmail(String e) {
		email = e;
	}
	
	
	//Getting values from idCode, fName, lName, birthDate, address, phone and email
	public int getIdCode() {
		return idCode;
	}
	
	public String getFName() {
		return fName;
	}
	
	
	public String getLName() {
		return lName;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getEmail() {
		return email;
	}
	
}
