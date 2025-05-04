public class Car {
      
	private String carID;
	private String model;
	private String brand;
	private double baseprice;
	private boolean isavailable;
	
	
	public Car(String carID,String model,String brand,double baseprice) {
		this.carID = carID;
		this.model = model;
		this.brand = brand;
		this.baseprice = baseprice;
		this.isavailable = true;
	}
	
	public String getID() {
		return carID;
	}
	
	public String getmodel() {
		return model;
	}
	
	public String getbrand() {
		return brand;
	}
	
	public double getbaseprice() {
		return baseprice;
	}
	
	public boolean isavail() {
		return isavailable;
	}
	
	public void rent() {
		// user has rented car already
		isavailable = false;
	}
	
	public void returnCar() {
		// user has returned the car
		isavailable = true;
	}
	
	public double CalculatePrice(int days) {
		return days * 2300;
	}
	
	
	
	
}
