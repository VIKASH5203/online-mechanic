package com.amdocs;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.amdocs.dao.AppointmentDao;
import com.amdocs.dao.CustomerDao;
import com.amdocs.dao.impl.AppointmentDaoImpl;
import com.amdocs.dao.impl.CustomerDaoImpl;
import com.amdocs.entity.Appointment;
import com.amdocs.entity.Customer;
import com.amdocs.exceptions.AppointmentNotFoundException;
import com.amdocs.exceptions.CustomerNotFoundException;

 class App 
{
	private static Scanner scanner = new Scanner(System.in);
		
	static void showCustomerMenu() throws SQLException {
		while (true) {
			System.out.println("\n -----------Enter your choice----------------");
			System.out.println(" 1. Register Customer.");
			System.out.println(" 2. Modify Customer Details");
			System.out.println(" 3. Delete Customer Details");
			System.out.println(" 4. View Single record");
			System.out.println(" 5. View all Records");
			System.out.println(" 6. Exit");
			
			int ch = Integer.parseInt(scanner.nextLine());

			switch (ch) {
			case 1:
				addCustomer();
				break;
			case 2:
				Customer customer=createCustomer();
				System.out.println("\n Enter the Id of the Customer to be Modifed.");
				int id_modify = Integer.parseInt(scanner.nextLine());
				modifyCustomerDetails(id_modify,customer);
				break;
			case 3:
				System.out.println("\n Enter the Id of the Customer to be Deleted.");
				int id_delete ;
				
				try {
					id_delete= Integer.parseInt(scanner.nextLine());
					deleteCustomerRecord(id_delete);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("\n Enter the Id of the Customer.");
				int id_find = Integer.parseInt(scanner.nextLine());
				viewCustomerWithId(id_find);
				break;
			case 5:
				viewAllCustomer();
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("Try again");
				break;
			}
		}
	}

	static void showAppointmentMenu() throws SQLException, AppointmentNotFoundException {
		while (true) {
			System.out.println("\n -----------Enter your choice----------------");
			System.out.println(" 1. Book Appointment.");
			System.out.println(" 2. Modify Appointment Details");
			System.out.println(" 3. Delete Appointment Details");
			System.out.println(" 4. View Single record");
			System.out.println(" 5. View all Records");
			System.out.println(" 6. Exit");
			
			int ch = Integer.parseInt(scanner.nextLine());

			switch (ch) {
			case 1:
				bookAppointment();
				break;
			case 2:
				Appointment app=createAppointment();
				System.out.println("\n Enter the Id of the Appointment to be Modifed.");
				int id_modify = Integer.parseInt(scanner.nextLine());
				modifyAppointmentDetails(id_modify, app);
				break;
			case 3:
				System.out.println("\n Enter the Id of the Appointment Id.");
				int appointmentId = Integer.parseInt(scanner.nextLine());
				deleteAppointmentRecord(appointmentId);
				break;
			case 4:
				System.out.println("\n Enter the Id of the Customer.");
				int customerId = Integer.parseInt(scanner.nextLine());
				viewAppointmentHistory(customerId);
				break;
			case 5:
				viewAllAppointmentRecord();
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("Try again");
				break;
			}
		}
	}
	

	

	public static void main( String[] args ) throws SQLException, AppointmentNotFoundException
    {
    	while (true) {
    		System.out.println("\n -----------Enter your choice----------------");
			System.out.println(" 1. Customer.");
			System.out.println(" 2. Mechanic");
			System.out.println(" 3. Exit");
			
			int ch = 0;
			
			try {
				ch= Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

			switch (ch) {
			case 1:
				showCustomerMenu();
				break;
			case 2:
				showAppointmentMenu();
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("Try again");
				break;
			}
		}
    }
    
    private static Customer createCustomer() {
    	Customer obj = new Customer();
    	
		System.out.println("Enter The Id: "); 
		int id = Integer.parseInt(scanner.nextLine()); 
		obj.setId(id); 
		System.out.println("Enter The User Name: ");
		String userName = scanner.nextLine();
		obj.setUserName(userName);
		System.out.println("Enter The Password: ");
		String password = scanner.nextLine();
		obj.setPass(password);
		System.out.println("Enter The First Name: ");
		String firstName = scanner.nextLine();
		obj.setFirstName(firstName);
		firstName = obj.getFirstName();
		System.out.println("Enter The Last Name: ");
		String lastName = scanner.nextLine();
		obj.setLastName(lastName);
		lastName = obj.getLastName();
		System.out.println("Enter The Phone number: ");
		String phoneNumber = scanner.nextLine();
		obj.setPhoneNumber(phoneNumber);
		phoneNumber = obj.getPhoneNumber();
		System.out.println("Enter The Email-Id: ");
		String emailId = scanner.nextLine();
		obj.setEmailId(emailId);
		System.out.println("Enter The Address: ");
		String adress = scanner.nextLine();
		obj.setAddress(adress);
		
		return obj;
	}
    
    
    private static Appointment createAppointment() {
        Appointment appointment = new Appointment();

        System.out.println("Enter Appointment ID: ");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        appointment.setAppointmentId(appointmentId);

        System.out.println("Enter Customer ID: ");
        int customerId = Integer.parseInt(scanner.nextLine());
        appointment.setCustomerId(customerId);

        System.out.println("Enter Mechanic ID: ");
        int mechanicId = Integer.parseInt(scanner.nextLine());
        appointment.setMechanicId(mechanicId);

        System.out.println("Enter Appointment Date: ");
        String appointmentDate = scanner.nextLine();
        appointment.setDate(appointmentDate);

        System.out.println("Enter Appointment Time: ");
        String appointmentTime = scanner.nextLine();
        appointment.setTime(appointmentTime);

        System.out.println("Enter Required Service ID: ");
        System.out.println("Services with service ID: [101:marine mechanic, 102:aircraft mechanic,"
        		+ " 103:race car mechanics, 104:automotive mechanic,"
        		+ " 105:diesel mechanic, 106:heavy equipment mechanic, 107: small engine mechanic");
        int serviceId = Integer.parseInt(scanner.nextLine());
        appointment.setServiceId(serviceId);

        return appointment;
    }

    
    private static CustomerDao customerDao = new CustomerDaoImpl();
    private static AppointmentDao appointmentDao = new AppointmentDaoImpl();
    
	
	private static void addCustomer() throws SQLException {
		Customer createCustomer = createCustomer();
		customerDao.addCustomer(createCustomer);
	}
	
	private static void viewAllCustomer() throws SQLException {
		List<Customer> allCustomers=customerDao.findAllCustomer();
		for(Customer customer:allCustomers) {
			System.out.println(customer);
		} 
	}
	
	private static void viewCustomerWithId(int id) throws SQLException {
		Customer customer;
		try {
			customer = customerDao.findCustomer(id);
			System.out.println(customer);
		} catch (SQLException e) {
				e.printStackTrace();
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
		}
	} 
	
	private static void deleteCustomerRecord(int id) throws SQLException{
		Customer customer;
		try {
			customer = customerDao.findCustomer(id);
			System.out.println(customer.getFirstName()+"'s record is deleted now");
			customerDao.deleteCustomerRecord(id);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void modifyCustomerDetails(int id, Customer customer) throws SQLException {
		customerDao.modifyCustomerDetails(id, customer);
		System.out.println("Customer Modified Successfully");
	}
	
	private static void bookAppointment() throws SQLException {
		Appointment app=createAppointment();
		appointmentDao.bookAppointment(app);
		System.out.println("Appointment Booked Successfully");
	}
	
	private static void viewAppointmentHistory(int customerId) throws SQLException {
		List<Appointment> apps=appointmentDao.viewAppointment(customerId);
		for(Appointment app:apps) {
			System.out.println(app);
		} 	
	}
	
	private static void deleteAppointmentRecord(int appointmentId) throws AppointmentNotFoundException, SQLException {
		try {
			System.out.println("Appointment with id: "+appointmentId+" is deleted");
			deleteAppointmentRecord(appointmentId);
		}catch(SQLException e){
			e.printStackTrace();
		} catch (AppointmentNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void viewAllAppointmentRecord() throws SQLException {
		List<Appointment> apps=appointmentDao.viewAllAppointment();
		for(Appointment app:apps) {
			System.out.println(app);
		} 	
	}

	private static void modifyAppointmentDetails(int appointmentId, Appointment appointment) throws SQLException {
		appointmentDao.modifyAppointment(appointmentId, appointment);
		System.out.println("Appointment Modified Successfully");
		
	}
}
