
public class Rental {
      
	private Car car;
	private Customer customer;
	private int days;
	
	Rental(Car car,Customer customer,int days) {
		this.car = car;
		this.customer = customer;
		this.days = days;
	}
	
	public Car getcar() {
		return car;
	}
	
	public Customer getcustomer() {
		return customer;
	}
	
	public int getdays() {
		return days;
	}
	
	
}
