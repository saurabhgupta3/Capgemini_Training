package com.dk;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

class Employee {

	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private LocalDate hireDate;
	private String designation;
	private double salary;
	private Integer managerId;
	private Department department;
	
	
	public Employee(Integer employeeId, String firstName, String lastName,
			String email, String phoneNumber, LocalDate hireDate,
			String designation, double salary, Integer managerId,
			Department department) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.designation = designation;
		this.salary = salary;
		this.managerId = managerId;
		this.department = department;
	}
	
	public Employee() {
		super();
	}

	

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate
				+ ", designation=" + designation + ", salary=" + salary
				+ ", managerId=" + managerId + ", department=" + department
				+ "]";
	}
	
}
class EmployeeRepository {

	private static final List<Employee> employees;
	private static final List<Department> departments;
	
	static {
		departments = new ArrayList<Department>();
		//populate departments
		departments.add(new Department(10,"Administration",100));
		departments.add(new Department(20,"Production",201));
		departments.add(new Department(30,"Sales",124));
		departments.add(new Department(40,"Finance",205));
		departments.add(new Department(50,"Customer Support",100));
		//populate employees 
		employees= new ArrayList<Employee>();
		employees.add(new Employee( 100, "Steven", "King", 
				"SKING", "515.123.4567", LocalDate.of(1997,Month.JUNE,17),
				"President", 24000,null, departments.get(0)));
		employees.add(new Employee( 101, "Neena", "Kochhar", 
				"NKOCHHAR", "515.123.4568", LocalDate.of(1999,Month.SEPTEMBER,21),
				"Vice President", 17000,100, departments.get(0)));
		employees.add(new Employee( 102, "Lex", "De Haan", 
				"LDEHAAN", "515.123.4569", LocalDate.of(2003,Month.JUNE,13),
				"Vice President", 17000,100, departments.get(0)));
		employees.add(new Employee( 201, "Michael", "Hartstein", 
				"MHARTSTE", "515.123.5555", LocalDate.of(1996,Month.FEBRUARY,17),
				"Manager", 13000,100, departments.get(1)));
		employees.add(new Employee( 202, "Pat", "Fay", 
				"PFAY", "603.123.6666", LocalDate.of(2007,Month.AUGUST,17),
				"Deputy Manager", 6000,201, departments.get(1)));
		employees.add(new Employee( 124, "Kevin", "Mourgos", 
				"KMOURGOS", "650.123.5234", LocalDate.of(2009,Month.NOVEMBER,16),
				"Manager", 5800,100, departments.get(2)));
		employees.add(new Employee( 141, "Trenna", "Rajs", 
				"TRAJS", "650.121.8009", LocalDate.of(1995,Month.OCTOBER,17),
				"Clerk", 3500,124, departments.get(2)));
		employees.add(new Employee( 205, "Shelley", "Higgins", 
				"SHIGGINS", "515.123.8080", LocalDate.of(2004,Month.JUNE,07),
				"Manager", 12000,101, departments.get(3)));
		employees.add(new Employee( 206, "William", "Gietz", 
				"WGIETZ", "515.123.8181", LocalDate.of(2004,Month.JUNE,07),
				"Accountant", 8300,205, departments.get(3)));
		employees.add(new Employee( 199, "Douglas", "Grant", 
				"DGRANT", "650.507.9844", LocalDate.of(2000,Month.JANUARY,13),
				"Clerk", 2600,205, departments.get(3)));
		employees.add(new Employee( 200, "Jennifer", "Whalen", 
				"JWHALEN", "515.123.4444", LocalDate.of(2007,Month.SEPTEMBER,17),
				"Admin Assistant", 4400,102, null));
		employees.add(new Employee( 198, "Donald", "OConnell", 
				"DOCONNEL", "650.507.9833", LocalDate.of(2009,Month.JUNE,21),
				"Clerk", 2600,null, null));
	}
	
	public static List<Employee> getEmployees() {
		return employees;
	}
	public static List<Department> getDepartments() {
		return departments;
	}
}
class Department {

	private int departmentId;
	private String departmentName;
	private int managerId;

	public Department(int departmentId, String departmentName, int managerId) {
		// TODO Auto-generated constructor stub
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.managerId = managerId;

	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

}
public class SumOfAll {
	public static void solve1() {
		List<Employee> ls = EmployeeRepository.getEmployees();
		double ans = 0;
		System.out.println(ls.stream().mapToDouble(emp -> emp.getSalary()).sum());
	}
	public static void solve3() {
		List<Employee> ls = EmployeeRepository.getEmployees();
		System.out.println(ls.stream().min((e1, e2) -> e1.getHireDate().compareTo(e2.getHireDate())));
	}
	public static void solve11() {
		List<Employee> ls = EmployeeRepository.getEmployees();
	}
	public static void solve5() {
		List<Employee> ls = EmployeeRepository.getEmployees();
		
	}
	public static void main(String[] args) {
		solve1();
		solve3();
		solve11();
		solve5();
	}
}
