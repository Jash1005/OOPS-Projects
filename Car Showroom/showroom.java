import java.util.Scanner;

public class showroom implements utility {
	  String showroom_name;
	    String showroom_address;
	    int total_employee;
	    int total_cars_in_stock;
	    String manager_name;
	    
	    @Override
	    public void get_details() {
	        System.out.println("Showroom Name : " + showroom_name);
	        System.out.println("Showroom Address : " + showroom_address);
	        System.out.println("Manager Name : " + manager_name);
	        System.out.println("Total Cars : " + total_cars_in_stock);
	        System.out.println("Total Employee : " + total_employee);
	    }
	    
	    @Override
	    public void set_details() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("======================= *** ENTER SHOWROOM DETAILS *** =======================");
	        System.out.println();
	        // showroom name
	        System.out.println("Showroom Name : ");
	        showroom_name  = sc.nextLine();
	        // showroom address
	        System.out.println("Showroom Address : ");
	        showroom_address = sc.nextLine();
	        // manager name
	        System.out.println("Manager Name : ");
	        manager_name = sc.nextLine();
	        // total Employee
	        System.out.println("Total number of Employee : ");
	        total_employee = sc.nextInt();
	        // total cars in stock
	        System.out.println("Total cars in Stock : ");
	        total_cars_in_stock = sc.nextInt();
	        
	    }
}
