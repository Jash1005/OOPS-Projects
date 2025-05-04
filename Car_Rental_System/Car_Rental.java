import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Car_Rental {
     
	private List<Car> cars;
	private List<Customer> customers;
	private List<Rental> rentals;
	
	Car_Rental() {
		this.cars = new ArrayList<>();
		this.customers = new ArrayList<>();
		this.rentals = new ArrayList<>();
	}
	
	public void addcar(Car car) {
		cars.add(car);
	}
	
	public void addcustomer(Customer customer) {
		customers.add(customer);
	}
	
	
	public void rent_car(Car car,Customer customer,int days) {
		if(car.isavail()) {
			car.rent();
			rentals.add(new Rental(car,customer,days));
		}
		else {
			System.out.println("Car is not available for rent");
		}
	}
	
	
	public void returnCar(Car car) {
		car.returnCar();
		Rental rental_to_remove = null;
		
		for(Rental r : rentals) {
			if(r.getcar() == car) {
				rentals.remove(r);
				System.out.println("Successfully returned");
				break;
			}
		}
	}
	
	
	public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Car Rental System =====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.println("\n== Rent a Car ==\n");
                System.out.print("Enter your name: ");
                String customerName = scanner.nextLine();

                System.out.println("\nAvailable Cars:");
                for (Car car : cars) {
                    if (car.isavail()) {
                        System.out.println(car.getID() + " - " + car.getbrand() + " " + car.getmodel());
                    }
                }

                System.out.print("\nEnter the car ID you want to rent: ");
                String carId = scanner.nextLine();

                System.out.print("Enter the number of days for rental: ");
                int rentalDays = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                Customer newCustomer = new Customer(customerName , "CUS" + (customers.size() + 1), "78946123");
                addcustomer(newCustomer);

                Car selectedCar = null;
                for (Car car : cars) {
                    if (car.getID().equals(carId) && car.isavail()) {
                        selectedCar = car;
                        break;
                    }
                }

                if (selectedCar != null) {
                    double totalPrice = selectedCar.CalculatePrice(rentalDays);
                    System.out.println("\n== Rental Information ==\n");
                    System.out.println("Customer ID: " + newCustomer.getcustomerID());
                    System.out.println("Customer Name: " + newCustomer.getcustomername());
                    System.out.println("Car: " + selectedCar.getbrand() + " " + selectedCar.getmodel());
                    System.out.println("Rental Days: " + rentalDays);
                    System.out.printf("Total Price: $%.2f%n", totalPrice);

                    System.out.print("\nConfirm rental (Y/N): ");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                        rent_car(selectedCar, newCustomer, rentalDays);
                        System.out.println("\nCar rented successfully.");
                    } else {
                        System.out.println("\nRental canceled.");
                    }
                } else {
                    System.out.println("\nInvalid car selection or car not available for rent.");
                }
            } else if (choice == 2) {
                System.out.println("\n== Return a Car ==\n");
                System.out.print("Enter the car ID you want to return: ");
                String carId = scanner.nextLine();

                Car carToReturn = null;
                for (Car car : cars) {
                    if (car.getID().equals(carId) && !car.isavail()) {
                        carToReturn = car;
                        break;
                    }
                }

                if (carToReturn != null) {
                    Customer customer = null;
                    for (Rental rental : rentals) {
                        if (rental.getcar() == carToReturn) {
                            customer = rental.getcustomer();
                            break;
                        }
                    }

                    if (customer != null) {
                        returnCar(carToReturn);
                        System.out.println("Car returned successfully by " + customer.getcustomername());
                    } else {
                        System.out.println("Car was not rented or rental information is missing.");
                    }
                } else {
                    System.out.println("Invalid car ID or car is not rented.");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        System.out.println("\nThank you for using the Car Rental System!");
    }
}
 
