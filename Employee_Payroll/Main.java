import java.util.*;

abstract class Employee{
	private String name;
	private int id;
	
	public Employee(String name,int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	abstract double calculate_Salary();
	
	
	public String tostring() {
		return "Employee[name" + name + "id" + id + "salary " + calculate_Salary() + "]" ;
	}
	
}


class FullTimeEmployee extends Employee {
	
	private double monthly_salary;
	
	public FullTimeEmployee(String name,int id,double monthly_salary) {
		super(name,id);
		this.monthly_salary = monthly_salary;
	}
	
	@Override
	public double calculate_Salary() {
		return monthly_salary;
	}
}


class PartTimeEmployee extends Employee {
	
	private int hours_worked;
	private double hourly_rate;
	
	PartTimeEmployee(String name,int id,int hours_worked,int hourly_rate) {
		super(name,id);
		this.hourly_rate = hourly_rate;
		this.hours_worked = hours_worked;
	}
	
	@Override
	public double calculate_Salary() {
		return hours_worked * hourly_rate;
	}
}



class Payrol {
	private ArrayList<Employee> employeelist; // each index store name,id and salary ,that index represent employee object

    public Payrol() {
    	employeelist = new ArrayList<>();
    }
    
    public void addEmployee(Employee employee) {
    	employeelist.add(employee);
    }
    
    public void removeEmployee(int id) {
        boolean removed = false;
        
    	for(Employee emp : employeelist) {
    		if(emp.getId() == id) {
    			employeelist.remove(emp);
    			removed = true;
    			break;
    		}
    	}
    	
    	if(!removed) {
    		System.out.println("ID doesn't exist");
    	}
    }
    
    public void displayEmployee() {
    	
    	for(Employee emp : employeelist) {
    		System.out.println(emp);
    	}
    }
}



public class Main {
      public static void main(String args[]) {
    	  Payrol p = new Payrol();
    	  FullTimeEmployee f1 = new FullTimeEmployee("Jash", 12, 70000.0);
    	  PartTimeEmployee p1 = new PartTimeEmployee("Vikas", 15, 7 , 100); 
          //adding emp to payrol
    	  p.addEmployee(f1);
    	  p.addEmployee(p1);
    	  
    	  System.out.println("Initial Employee Details : ");
    	  p.displayEmployee();
    	  
    	  System.out.println("Removing Employee");
    	  p.removeEmployee(12);
    	  
    	  p.displayEmployee();
      }
 }
