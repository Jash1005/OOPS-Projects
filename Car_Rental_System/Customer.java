
public class Customer {
      
	private String customer_name;
	private String customerID;
	private String phone_number;
	
	public Customer(String customer_name,String customerID,String phone_number) {
		this.customer_name = customer_name;
		this.customerID = customerID;
		this.phone_number = phone_number;
	}
	
	public String getcustomername() {
		return customer_name;
	}
	
	public String getcustomerID() {
	   return customerID;
	}
	
	public String getnumber() {
		return phone_number;
	}
	
	
}
